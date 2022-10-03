package dao;

import models.Country;
import models.RoleStaff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.management.relation.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleStaffDAO implements IDAO<RoleStaff> {
    private final String INSERT_ROLE_STAFF = "INSERT INTO staff_roles(description) VALUES(?)";
    private final String GET_ROLE_STAFF_BY_ID = "SELECT * FROM staff_roles WHERE id = ?";
    private final String GET_ALL_ROLE_STAFF = "SELECT * FROM staff_roles";
    private final String DELETE_BY_ID = "DELETE FROM staff_roles WHERE id = ?";
    private final String UPDATE_ROLE_STAFF = "UPDATE staff_roles SET description = ? WHERE id = ?";

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hall_concert","root","2443");
    private final Logger logger = LogManager.getLogger(RoleStaffDAO.class);

    public RoleStaffDAO() throws SQLException {
    }

    @Override
    public void insert(RoleStaff object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_ROLE_STAFF);
            preparedStatement.setString(1, object.getDescription());
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
    public void update(int id, RoleStaff object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_ROLE_STAFF);

            preparedStatement.setString(1, object.getDescription());
            preparedStatement.setInt(2, id);

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
    public List<RoleStaff> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_ROLE_STAFF);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<RoleStaff> roleStaffs = new ArrayList<>();

            while (result.next()) {
                RoleStaff roleStaff = new RoleStaff(result.getInt("id"), result.getString("description"));
                roleStaffs.add(roleStaff);
            }

            return roleStaffs;
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
    public RoleStaff getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ROLE_STAFF_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            RoleStaff roleStaff = new RoleStaff();
            roleStaff.setId(result.getInt("id"));
            roleStaff.setDescription(result.getString("description"));

            return roleStaff;
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
