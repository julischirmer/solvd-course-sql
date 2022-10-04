package dao;

import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ConnectionPool.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HallDAO implements IDAO<Hall>{
    private final String INSERT_HALL = "INSERT INTO hall(name,address,capacity,country_id) VALUES(?,?,?,?)";
    private final String GET_HALL_BY_ID = "SELECT h.*, c.country_name FROM hall h INNER JOIN country c ON h.country_id = c.id WHERE h.id = ?";
    private final String GET_ALL_HALL = "SELECT h.*, c.country_name FROM hall h INNER JOIN country c ON h.country_id = c.id ORDER BY h.id";
    private final String DELETE_BY_ID = "DELETE FROM hall WHERE id = ?";
    private final String UPDATE_HALL = "UPDATE hall SET name = ?,address=? ,capacity =? ,country_id =? WHERE id = ?";

    private final Logger logger = LogManager.getLogger(HallDAO.class);

    public HallDAO() throws SQLException {
    }

    @Override
    public void insert(Hall object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_HALL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getAddress());
            preparedStatement.setInt(3, object.getCapacity());
            preparedStatement.setInt(4, object.getCountry().getId());
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
    public void update(int id, Hall object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_HALL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getAddress());
            preparedStatement.setInt(3, object.getCapacity());
            preparedStatement.setInt(4, object.getCountry().getId());
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
    public List<Hall> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_HALL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Hall> halls = new ArrayList<>();

            while (result.next()) {

                Country country = new Country(result.getInt("country_id"),result.getString("country_name"));
                Hall hall = new Hall(result.getInt("id"),result.getString("name") ,result.getString("address"),result.getInt("capacity"), country);

                halls.add(hall);
            }

            return halls;
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
    public Hall getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_HALL_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Country country = new Country(result.getInt("country_id"),result.getString("country_name"));
            Hall hall = new Hall(result.getInt("id"),result.getString("name") ,result.getString("address"),result.getInt("capacity"), country);

            return hall;
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
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
