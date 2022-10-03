package dao;

import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO implements IDAO<Ticket>{
    private final String INSERT_TICKET = "INSERT INTO ticket(cost,row_letter,seat_no,sector,booking_id,concert_id) VALUES(?,?,?,?,?,?)";
    private final String GET_TICKET_BY_ID = "SELECT t.*, b.date_book, b.customer_id, b.payment_id,cust.document_no, cust.name as 'customer_name', cust.last_name as 'customer_last_name', pay.type_pay, c.date_concert, c.start_time, c.hall_id, h.name as 'hall_name',h.country_id, country.country_name FROM ticket t INNER JOIN booking b ON t.booking_id = b.id INNER JOIN concert c ON t.concert_id = c.id INNER JOIN customer cust ON cust.id = b.customer_id INNER JOIN payment pay ON pay.id = b.payment_id INNER JOIN hall h ON h.id = c.hall_id INNER JOIN country ON country.id = h.country_id WHERE t.id = ?";
    private final String GET_ALL_TICKET = "SELECT t.*, b.date_book, b.customer_id, b.payment_id,cust.document_no, cust.name as 'customer_name', cust.last_name as 'customer_last_name', pay.type_pay, c.date_concert, c.start_time, c.hall_id, h.name as 'hall_name',h.country_id, country.country_name FROM ticket t INNER JOIN booking b ON t.booking_id = b.id INNER JOIN concert c ON t.concert_id = c.id INNER JOIN customer cust ON cust.id = b.customer_id INNER JOIN payment pay ON pay.id = b.payment_id INNER JOIN hall h ON h.id = c.hall_id INNER JOIN country ON country.id = h.country_id ORDER BY t.id;";
    private final String DELETE_BY_ID = "DELETE FROM ticket WHERE id = ?";
    private final String UPDATE_TICKET = "UPDATE ticket SET cost = ?,row_letter = ?,seat_no =?,sector =?,booking_id =?,concert_id =? WHERE id = ?";

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hall_concert","root","2443");
    private final Logger logger = LogManager.getLogger(TicketDAO.class);

    public TicketDAO() throws SQLException {
    }

    @Override
    public void insert(Ticket object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_TICKET);
            preparedStatement.setDouble(1, object.getCost());
            preparedStatement.setString(2, object.getRowLetter());
            preparedStatement.setInt(3, object.getSeatNo());
            preparedStatement.setString(4, object.getSector());
            preparedStatement.setInt(5, object.getBooking().getId());
            preparedStatement.setInt(6, object.getConcert().getId());
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
    public void update(int id, Ticket object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_TICKET);

            preparedStatement.setDouble(1, object.getCost());
            preparedStatement.setString(2, object.getRowLetter());
            preparedStatement.setInt(3, object.getSeatNo());
            preparedStatement.setString(4, object.getSector());
            preparedStatement.setInt(5, object.getBooking().getId());
            preparedStatement.setInt(6, object.getConcert().getId());
            preparedStatement.setInt(7, id);

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
    public List<Ticket> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_TICKET);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Ticket> tickets = new ArrayList<>();

            while (result.next()) {


                Country country = new Country(result.getInt("country_id"),result.getString("country_name"));
                Hall hall = new Hall(result.getInt("hall_id"),result.getString("hall_name"), country);
                Concert concert = new Concert(result.getInt("concert_id"),result.getString("date_concert"),result.getString("start_time"),hall);
                Payment payment = new Payment(result.getInt("payment_id"), result.getString("type_pay"));
                Customer customer = new Customer(result.getInt("customer_id"), result.getInt("document_no"), result.getString("customer_name"), result.getString("customer_last_name"));
                Booking booking = new Booking(result.getInt("booking_id"),result.getString("date_book"),customer,payment);

                Ticket ticket = new Ticket(result.getInt("id"),result.getDouble("cost"),result.getString("row_letter"), result.getInt("seat_no"),result.getString("sector"),booking,concert);

                tickets.add(ticket);
            }

            return tickets;
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
    public Ticket getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_TICKET_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Country country = new Country(result.getInt("country_id"),result.getString("country_name"));
            Hall hall = new Hall(result.getInt("hall_id"),result.getString("hall_name"), country);
            Concert concert = new Concert(result.getInt("concert_id"),result.getString("date_concert"),result.getString("start_time"),hall);
            Payment payment = new Payment(result.getInt("payment_id"), result.getString("type_pay"));
            Customer customer = new Customer(result.getInt("customer_id"), result.getInt("document_no"), result.getString("customer_name"), result.getString("customer_last_name"));
            Booking booking = new Booking(result.getInt("booking_id"),result.getString("date_book"),customer,payment);

            Ticket ticket = new Ticket(result.getInt("id"),result.getDouble("cost"),result.getString("row_letter"), result.getInt("seat_no"),result.getString("sector"),booking,concert);

            return ticket;
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
