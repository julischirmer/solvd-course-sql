package dao;

import models.Artist;
import models.Country;
import models.RoleStaff;
import models.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO implements IDAO<Staff>{
    private final String INSERT_STAFF = "INSERT INTO staff(document_no,name,last_name,role_id) VALUES(?,?,?,?)";
    private final String GET_STAFF_BY_ID = "SELECT s.*, sr.description FROM staff s INNER JOIN staff_roles sr ON s.role_id = sr.id WHERE s.id = ?";
    private final String GET_ALL_STAFF = "SELECT s.*, sr.description FROM staff s INNER JOIN staff_roles sr ON s.role_id = sr.id ORDER BY s.id";
    private final String DELETE_BY_ID = "DELETE FROM staff WHERE id = ?";
    private final String UPDATE_STAFF = "UPDATE staff SET" +
            " document_no = ?, name = ?, last_name = ?, role_id = ? WHERE id = ?";

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hall_concert","root","2443");
    private final Logger logger = LogManager.getLogger(CustomerDAO.class);

    public StaffDAO() throws SQLException {
    }

    @Override
    public void insert(Staff object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_STAFF);
            preparedStatement.setInt(1, object.getDocumentNo());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setString(3, object.getLastName());
            preparedStatement.setInt(4, object.getRoleStaff().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }

    @Override
    public void update(int id, Staff object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_STAFF);

            preparedStatement.setInt(1, object.getDocumentNo());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setString(3, object.getLastName());
            preparedStatement.setInt(4, object.getRoleStaff().getId());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }

    @Override
    public List<Staff> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_STAFF);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Staff> staffs = new ArrayList<>();

            while (result.next()) {

                RoleStaff roleStaff = new RoleStaff(result.getInt("role_id"),result.getString("description"));
                Staff staff = new Staff(result.getInt("id"),result.getInt("document_no") ,result.getString("name"),result.getString("last_name"), roleStaff);

                staffs.add(staff);
            }

            return staffs;
        } catch (SQLException e) {
            logger.error(e);
            return null;
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }

    @Override
    public Staff getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_STAFF_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            RoleStaff roleStaff = new RoleStaff(result.getInt("role_id"),result.getString("description"));
            Staff staff = new Staff(result.getInt("id"), result.getInt("document_no"), result.getString("name"), result.getString("last_name"),roleStaff);

            return staff;
        } catch (SQLException e) {
            logger.error(e);
            return null;
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {

            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }
}
