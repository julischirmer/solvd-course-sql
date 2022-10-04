package dao;

import models.Artist;
import models.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ConnectionPool.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements IDAO<Country>{
    private final String INSERT_COUNTRY = "INSERT INTO country(country_name) VALUES(?)";
    private final String GET_COUNTRY_BY_ID = "SELECT * FROM country WHERE id = ?";
    private final String GET_ALL_COUNTRY = "SELECT * FROM country";
    private final String DELETE_BY_ID = "DELETE FROM country WHERE id = ?";
    private final String UPDATE_COUNTRY = "UPDATE country SET country_name = ? WHERE id = ?";
    private final Logger logger = LogManager.getLogger(CountryDAO.class);

    public CountryDAO() throws SQLException {
    }

    @Override
    public void insert(Country object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_COUNTRY, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
    public void update(int id, Country object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_COUNTRY, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

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
    public List<Country> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_COUNTRY, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Country> countries = new ArrayList<>();

            while (result.next()) {
                Country country = new Country(result.getInt("id"), result.getString("country_name"));

                countries.add(country);
            }

            return countries;
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
    public Country getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_COUNTRY_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Country country = new Country();
            country.setId(result.getInt("id"));
            country.setDescription(result.getString("country_name"));

            return country;
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
