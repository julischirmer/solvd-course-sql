package dao;

import models.Country;
import models.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO implements IDAO<Payment>{
    private final String INSERT_PAYMENT = "INSERT INTO payment(type_pay) VALUES(?)";
    private final String GET_PAYMENT_BY_ID = "SELECT * FROM payment WHERE id = ?";
    private final String GET_ALL_PAYMENT = "SELECT * FROM payment";
    private final String DELETE_BY_ID = "DELETE FROM payment WHERE id = ?";
    private final String UPDATE_PAYMENT = "UPDATE payment SET type_pay =  ? WHERE id = ?";

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hall_concert","root","2443");
    private final Logger logger = LogManager.getLogger(PaymentDAO.class);

    public PaymentDAO() throws SQLException {
    }

    @Override
    public void insert(Payment object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_PAYMENT);
            preparedStatement.setString(1, object.getTypePay());
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
    public void update(int id, Payment object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_PAYMENT);

            preparedStatement.setString(1, object.getTypePay());
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
    public List<Payment> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_PAYMENT);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Payment> payments = new ArrayList<>();

            while (result.next()) {
                Payment payment = new Payment(result.getInt("id"), result.getString("type_pay"));

                payments.add(payment);
            }

            return payments;
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
    public Payment getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_PAYMENT_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Payment payment = new Payment();
            payment.setId(result.getInt("id"));
            payment.setTypePay(result.getString("type_pay"));

            return payment;
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
