package dao;

import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConcertDAO implements IDAO<Concert> {
    private final String INSERT_CONCERT = "INSERT INTO concert(date_concert,start_time,hall_id) " + "VALUES(?,?,?)";
    private final String GET_CONCERT_BY_ID = "SELECT c.*, h.name as 'hall_name', h.address, h.capacity, h.country_id, ct.country_name FROM concert c INNER JOIN hall h ON h.id = c.hall_id INNER JOIN country ct ON ct.id = h.country_id WHERE c.id = ?";
    private final String GET_ALL_CONCERT = "SELECT c.*, h.name as 'hall_name', h.address, h.capacity, h.country_id, ct.country_name, a.id as 'artist_id', a.name as 'artist_name', s.id as 'staff_id', s.document_no, s.name as 'staff_name', s.last_name as 'staff_last_name'FROM concert c INNER JOIN hall h ON c.hall_id = h.id INNER JOIN country ct ON h.country_id = ct.id RIGHT JOIN concert_has_artist ca ON c.id = ca.concert_id RIGHT JOIN concert_staff cs ON c.id = cs.concert_id RIGHT JOIN artist a ON a.id = ca.artist_id RIGHT JOIN staff s ON s.id = cs.staff_id WHERE c.id is not null";
    private final String DELETE_BY_ID = "DELETE FROM concert WHERE id = ?";
    private final String UPDATE_CONCERT = "UPDATE concert SET date_concert = ?,start_time = ?,hall_id =? WHERE flight_id = ?";

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hall_concert","root","2443");
    private final Logger logger = LogManager.getLogger(ConcertDAO.class);

    public ConcertDAO() throws SQLException {
    }

    @Override
    public void insert(Concert object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_CONCERT);
            preparedStatement.setString(1, object.getDateConcert());
            preparedStatement.setString(2, object.getStartTime());
            preparedStatement.setInt(3, object.getHall().getId());
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
    public void update(int id, Concert object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_CONCERT);

            preparedStatement.setString(1, object.getDateConcert());
            preparedStatement.setString(2, object.getStartTime());
            preparedStatement.setInt(3, object.getHall().getId());
            preparedStatement.setInt(4, id);

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
    public List<Concert> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_CONCERT);
            ResultSet result = preparedStatement.executeQuery();


            ArrayList<Concert> concerts = new ArrayList<>();

            while (result.next()) {

                ArrayList<Artist> artists = new ArrayList<>();
                ArrayList<Staff> staffs = new ArrayList<>();

                Country country = new Country(result.getInt("country_id"),result.getString("country_name"));
                Hall hall = new Hall(result.getInt("hall_id"),result.getString("hall_name"),result.getString("address"),result.getInt("capacity"),country);
                Artist artist = new Artist(result.getInt("artist_id"), result.getString("artist_name"));
                Staff staff = new Staff(result.getInt("staff_id"),result.getInt("document_no"),result.getString("staff_name"),result.getString("staff_last_name"));

                artists.add(artist);
                staffs.add(staff);

                Concert concert = new Concert(result.getInt("id"),result.getString("date_concert"),result.getString("start_time"),hall,artists,staffs);
                concerts.add(concert);

            }

            return concerts;
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
    public Concert getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_CONCERT_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Country country = new Country(result.getInt("country_id"),result.getString("country_name"));
            Hall hall = new Hall(result.getInt("hall_id"),result.getString("hall_name"),result.getString("address"),result.getInt("capacity"),country);
            Concert concert = new Concert(result.getInt("id"),result.getString("date_concert"),result.getString("start_time"),hall);

            return concert;
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
