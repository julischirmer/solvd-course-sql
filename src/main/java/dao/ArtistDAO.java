package dao;

import models.Artist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ArtistDAO implements IDAO<Artist> {
    private final String INSERT_ARTIST = "INSERT INTO artist(name, country_id) " + "VALUES(?,?)";
    private final String GET_ARTIST_BY_ID = "SELECT * FROM artist WHERE id = ?";
    private final String GET_ALL_ARTIST = "SELECT * FROM artist";
    private final String DELETE_BY_ID = "DELETE FROM artist WHERE id = ?";
    private final String UPDATE_CITY = "UPDATE artist SET name =  ?, country_id = ? WHERE id = ?";
    private final String DELETE_ALL = "DELETE FROM artist";
    private final Logger logger = LogManager.getLogger(ArtistDAO.class);

    @Override
    public void insert(Artist object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(INSERT_ARTIST);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getCountry().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }

    @Override
    public void delete(Artist object) throws SQLException {

    }

    @Override
    public void update(Artist object) throws SQLException {

    }

    @Override
    public List<Artist> getAll(Artist object) throws SQLException {
        return null;
    }

    @Override
    public Artist getById(int id) throws SQLException {
        return null;
    }
}
