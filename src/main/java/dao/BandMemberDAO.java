package dao;

import ConnectionPool.ConnectionPool;
import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BandMemberDAO implements IDAO<BandMember>{
    private final String INSERT_BAND_MEMBER = "INSERT INTO hall(document_no,name,last_name,instrument_id,artist_id) VALUES(?,?,?,?,?)";
    private final String GET_BAND_MEMBER_BY_ID = "SELECT bm.*, i.instrument_name, a.name as 'artist_name', a.country_id,c.country_name FROM band_member bm INNER JOIN instrument i ON bm.instrument_id = i.id INNER JOIN artist a ON bm.artist_id = a.id INNER JOIN country c ON c.id = a.country_id WHERE bm.id = ?";
    private final String GET_ALL_BAND_MEMBER = "SELECT bm.*, i.instrument_name, a.name as 'artist_name', a.country_id,c.country_name FROM band_member bm INNER JOIN instrument i ON bm.instrument_id = i.id INNER JOIN artist a ON bm.artist_id = a.id INNER JOIN country c ON c.id = a.country_id ORDER BY bm.id";
    private final String DELETE_BY_ID = "DELETE FROM hall WHERE id = ?";
    private final String UPDATE_BAND_MEMBER = "UPDATE hall SET document_no = ?,name =?,last_name=?,instrument_id=?,artist_id=? WHERE id = ?";

    private final Logger logger = LogManager.getLogger(BandMemberDAO.class);

    public BandMemberDAO() throws SQLException {
    }

    @Override
    public void insert(BandMember object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_BAND_MEMBER, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, object.getDocumentNo());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setString(3, object.getLastName());
            preparedStatement.setInt(4, object.getInstrument().getId());
            preparedStatement.setInt(5, object.getArtist().getId());
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
    public void update(int id, BandMember object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_BAND_MEMBER, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, object.getDocumentNo());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setString(3, object.getLastName());
            preparedStatement.setInt(4, object.getInstrument().getId());
            preparedStatement.setInt(5, object.getArtist().getId());
            preparedStatement.setInt(6, id);

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
    public List<BandMember> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_BAND_MEMBER, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<BandMember> bandMembers = new ArrayList<>();

            while (result.next()) {

                Country country = new Country(result.getInt("country_id"),result.getString("country_name"));
                Artist artist = new Artist(result.getInt("artist_id"), result.getString("artist_name"), country);
                Instrument instrument = new Instrument(result.getInt("instrument_id"), result.getString("instrument_name"));
                BandMember bandMember = new BandMember(result.getInt("id"),result.getInt("document_no"),result.getString("name"),result.getString("last_name"),instrument,artist);

                bandMembers.add(bandMember);
            }

            return bandMembers;
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
    public BandMember getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_BAND_MEMBER_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Country country = new Country(result.getInt("country_id"),result.getString("country_name"));
            Artist artist = new Artist(result.getInt("artist_id"), result.getString("artist_name"), country);
            Instrument instrument = new Instrument(result.getInt("instrument_id"), result.getString("instrument_name"));
            BandMember bandMember = new BandMember(result.getInt("id"),result.getInt("document_no"),result.getString("name"),result.getString("last_name"),instrument,artist);

            return bandMember;
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
