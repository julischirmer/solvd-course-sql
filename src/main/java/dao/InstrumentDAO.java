package dao;

import models.Concert;
import models.Country;
import models.Instrument;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ConnectionPool.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrumentDAO implements IDAO<Instrument> {
    private final String INSERT_INSTRUMENT = "INSERT INTO instrument(instrument_name) VALUES(?)";
    private final String GET_INSTRUMENT_BY_ID = "SELECT * FROM instrument WHERE id = ?";
    private final String GET_ALL_INSTRUMENT = "SELECT * FROM instrument";
    private final String DELETE_BY_ID = "DELETE FROM instrument WHERE id = ?";
    private final String UPDATE_INSTRUMENT = "UPDATE instrument SET instrument_name = ? WHERE id = ?";
    private final Logger logger = LogManager.getLogger(InstrumentDAO.class);

    public InstrumentDAO() throws SQLException {
    }

    @Override
    public void insert(Instrument object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_INSTRUMENT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1, object.getName());
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
    public void update(int id, Instrument object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_INSTRUMENT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, object.getName());
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
    public List<Instrument> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_INSTRUMENT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Instrument> instruments = new ArrayList<>();

            while (result.next()) {
                Instrument instrument = new Instrument(result.getInt("id"), result.getString("instrument_name"));

                instruments.add(instrument);
            }

            return instruments;
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
    public Instrument getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection ;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_INSTRUMENT_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Instrument instrument = new Instrument();
            instrument.setId(result.getInt("id"));
            instrument.setName(result.getString("instrument_name"));

            return instrument;
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
