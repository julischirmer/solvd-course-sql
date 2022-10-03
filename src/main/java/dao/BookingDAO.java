package dao;

import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO implements IDAO<Booking>{
    private final String INSERT_BOOKING = "INSERT INTO booking(date_book,customer_id,payment_id) VALUES(?,?,?)";
    private final String GET_BOOKING_BY_ID = "SELECT b.id, b.date_book, c.id as 'customer_id', c.document_no, c.name, c.last_name, c.address, c.birthday, c.email ,p.id as 'payment_id',p.type_pay FROM booking b INNER JOIN customer c ON b.customer_id = c.id INNER JOIN payment P ON b.payment_id = p.id WHERE b.id = ?";
    private final String GET_ALL_BOOKING = "SELECT b.*, c.*, p.id as 'payment_id',p.type_pay FROM booking b INNER JOIN customer c ON b.customer_id = c.id INNER JOIN payment P ON b.payment_id = p.id ORDER BY b.id;";
    private final String DELETE_BY_ID = "DELETE FROM booking WHERE id = ?";
    private final String UPDATE_BOOKING = "UPDATE booking SET date_book = ?,customer_id =?,payment_id =? WHERE id = ?";

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hall_concert","root","2443");
    private final Logger logger = LogManager.getLogger(BookingDAO.class);

    public BookingDAO() throws SQLException {
    }

    @Override
    public void insert(Booking object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_BOOKING);
            preparedStatement.setString(1, object.getDateBook());
            preparedStatement.setInt(2, object.getCustomer().getId());
            preparedStatement.setInt(3, object.getPayment().getId());
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
    public void update(int id, Booking object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BOOKING);

            preparedStatement.setString(1, object.getDateBook());
            preparedStatement.setInt(2, object.getCustomer().getId());
            preparedStatement.setInt(3, object.getPayment().getId());
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
    public List<Booking> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_BOOKING);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Booking> bookings = new ArrayList<>();

            while (result.next()) {

                Payment payment = new Payment(result.getInt("payment_id"), result.getString("type_pay"));
                Customer customer =
                        new Customer(result.getInt("customer_id"), result.getInt("document_no"), result.getString("name"), result.getString("last_name"),
                                result.getString("address"), result.getString("birthday"),result.getString("email"));
                Booking booking = new Booking(result.getInt("id"),result.getString("date_book"),customer,payment);

                bookings.add(booking);
            }

            return bookings;
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
    public Booking getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_BOOKING_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Customer customer =
                    new Customer(result.getInt("customer_id"), result.getInt("document_no"), result.getString("name"), result.getString("last_name"),
                            result.getString("address"), result.getString("birthday"),result.getString("email"));
            Payment payment = new Payment();
            payment.setId(result.getInt("id"));
            payment.setTypePay(result.getString("type_pay"));
            Booking booking = new Booking(result.getString("date_book"),customer,payment);

            return booking;
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

