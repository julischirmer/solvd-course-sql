package dao;

import ConnectionPool.ConnectionPool;
import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConcertDAO implements IDAO<Concert> {
    private final String INSERT_CONCERT = "INSERT INTO concert(date_concert,start_time,hall_id) " + "VALUES(?,?,?)";
    private final String GET_CONCERT_BY_ID = "SELECT c.id as 'c.id', c.date_concert as 'c.date_concert', c.start_time as 'c.start_time', c.hall_id as 'c.hall_id',h.name as 'hall_name', h.address as 'h.address', h.capacity as 'h.capacity', c1.id as 'country_id_hall', c1.country_name as 'country_name_hall',a.id as 'artist_id',a.name, c2.id as 'country_id_artist', c2.country_name as 'country_name_artist',s.id as 'staff_id',s.document_no as 's.document_no', s.name as 's.name',s.last_name as 's.last_name',sr.id as 'staff_role_id', sr.description 'staff_role_description' FROM concert c INNER JOIN hall h ON c.hall_id = h.id INNER JOIN country c1 on c1.id = h.country_id RIGHT JOIN concert_has_artist cha ON cha.concert_id = c.id RIGHT JOIN concert_staff cs ON cs.concert_id = c.id INNER JOIN artist a ON a.id = cha.artist_id INNER JOIN country c2 ON c2.id = a.country_id INNER JOIN staff s ON s.id = cs.staff_id INNER JOIN staff_roles sr ON sr.id = s.role_id WHERE c.id = ?";
    private final String GET_ALL_CONCERT = "SELECT c.id as 'c.id', c.date_concert as 'c.date_concert', c.start_time as 'c.start_time', c.hall_id as 'c.hall_id',h.name as 'hall_name', h.address as 'h.address', h.capacity as 'h.capacity', c1.id as 'country_id_hall', c1.country_name as 'country_name_hall',a.id as 'artist_id',a.name, c2.id as 'country_id_artist', c2.country_name as 'country_name_artist',s.id as 'staff_id',s.document_no as 's.document_no', s.name as 's.name',s.last_name as 's.last_name',sr.id as 'staff_role_id', sr.description 'staff_role_description' FROM concert c INNER JOIN hall h ON c.hall_id = h.id INNER JOIN country c1 on c1.id = h.country_id RIGHT JOIN concert_has_artist cha ON cha.concert_id = c.id RIGHT JOIN concert_staff cs ON cs.concert_id = c.id INNER JOIN artist a ON a.id = cha.artist_id INNER JOIN country c2 ON c2.id = a.country_id INNER JOIN staff s ON s.id = cs.staff_id INNER JOIN staff_roles sr ON sr.id = s.role_id ORDER BY c.id;";
    private final String DELETE_BY_ID = "DELETE FROM concert WHERE id = ?";
    private final String UPDATE_CONCERT = "UPDATE concert SET date_concert = ?,start_time = ?,hall_id =? WHERE flight_id = ?";
    private final Logger logger = LogManager.getLogger(ConcertDAO.class);

    // SELECT c.*, h.name as 'hall_name', h.address, h.capacity, h.country_id, ct.country_name FROM concert c INNER JOIN hall h ON h.id = c.hall_id INNER JOIN country ct ON ct.id = h.country_id WHERE c.id = ?
    public ConcertDAO() throws SQLException {
    }

    @Override
    public void insert(Concert object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_CONCERT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_CONCERT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_CONCERT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = preparedStatement.executeQuery();


            ArrayList<Concert> concerts = new ArrayList<>();

            while (result.next()) {

                ArrayList<Artist> artists = new ArrayList<>();
                ArrayList<Staff> staffs = new ArrayList<>();

                Country country_artist = new Country(result.getInt("country_id_artist"), result.getString("country_name_artist"));
                Country country_hall = new Country(result.getInt("country_id_hall"), result.getString("country_name_hall"));
                RoleStaff roleStaff = new RoleStaff(result.getInt("staff_role_id"), result.getString("staff_role_description"));
                Hall hall = new Hall(result.getInt("c.hall_id"), result.getString("hall_name"), result.getString("h.address"), result.getInt("h.capacity"), country_hall);
                Artist artist = new Artist(result.getInt("artist_id"), result.getString("name"), country_artist);
                Staff staff = new Staff(result.getInt("staff_id"), result.getInt("s.document_no"), result.getString("s.name"), result.getString("s.last_name"), roleStaff);

                artists.add(artist);
                staffs.add(staff);

                Concert concert = new Concert(result.getInt("c.id"), result.getString("c.date_concert"), result.getString("c.start_time"), hall, artists, staffs);
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
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_CONCERT_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            Concert resultconcert = new Concert();

            while (result.next()) {

                ArrayList<Artist> artists = new ArrayList<>();
                ArrayList<Staff> staffs = new ArrayList<>();

                Country country_artist = new Country(result.getInt("country_id_artist"), result.getString("country_name_artist"));
                Country country_hall = new Country(result.getInt("country_id_hall"), result.getString("country_name_hall"));
                RoleStaff roleStaff = new RoleStaff(result.getInt("staff_role_id"), result.getString("staff_role_description"));
                Hall hall = new Hall(result.getInt("c.hall_id"), result.getString("hall_name"), result.getString("h.address"), result.getInt("h.capacity"), country_hall);
                Artist artist = new Artist(result.getInt("artist_id"), result.getString("name"), country_artist);
                Staff staff = new Staff(result.getInt("staff_id"), result.getInt("s.document_no"), result.getString("s.name"), result.getString("s.last_name"), roleStaff);

                artists.add(artist);
                staffs.add(staff);

                resultconcert = new Concert(result.getInt("c.id"), result.getString("c.date_concert"), result.getString("c.start_time"), hall, artists, staffs);
            }

            return resultconcert;
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
