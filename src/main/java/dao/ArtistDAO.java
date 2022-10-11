package dao;

import ConnectionPool.ConnectionPool;
import models.Artist;
import models.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtistDAO implements IDAO<Artist> {
    private final String INSERT_ARTIST = "INSERT INTO artist(name, country_id) VALUES(?,?)";
    private final String GET_ARTIST_BY_ID = "SELECT a.*, c.country_name FROM artist a INNER JOIN country c ON a.country_id = c.id WHERE a.id = ?";
    private final String GET_ALL_ARTIST = "SELECT a.*, c.country_name FROM artist a INNER JOIN country c ON a.country_id = c.id ORDER BY a.id";
    private final String DELETE_BY_ID = "DELETE FROM artist WHERE id = ?";
    private final String UPDATE_ARTIST = "UPDATE artist SET name =  ?, country_id = ? WHERE id = ?";

    private final Logger logger = LogManager.getLogger(ArtistDAO.class);

    public ArtistDAO() throws SQLException {
    }

    @Override
    public void insert(Artist object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_ARTIST, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getCountry().getId());
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
    public void update(int id, Artist object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_ARTIST, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getCountry().getId());
            preparedStatement.setInt(3, id);

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
    public ArrayList<Artist> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_ARTIST, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Artist> artists = new ArrayList<>();

            while (result.next()) {

                Country country = new Country(result.getInt("country_id"), result.getString("country_name"));
                Artist artist = new Artist(result.getInt("id"), result.getString("name"), country);

                artists.add(artist);
            }

            return artists;
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
    public Artist getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ARTIST_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Country country = new Country(result.getInt("country_id"), result.getString("country_name"));
            Artist artist = new Artist(result.getInt("id"), result.getString("name"), country);

            return artist;
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

