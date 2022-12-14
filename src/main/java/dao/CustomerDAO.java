package dao;

import ConnectionPool.ConnectionPool;
import models.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements IDAO<Customer> {
    private final String INSERT_CUSTOMER =
            "INSERT INTO customer(document_no, name, last_name, address, birthday,email) VALUES(?,?,?,?,?,?)";
    private final String GET_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE id = ?";
    private final String GET_ALL_CUSTOMER = "SELECT * FROM customer";
    private final String DELETE_BY_ID = "DELETE FROM customer WHERE id = ?";
    private final String UPDATE_CUSTOMER = "UPDATE customer SET document_no = ?, name = ?, last_name = ?, address = ?, birthday = ?, email = ? WHERE id = ?";
    private final Logger logger = LogManager.getLogger(CustomerDAO.class);

    public CustomerDAO() throws SQLException {
    }

    @Override
    public void insert(Customer object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_CUSTOMER, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1, object.getDocumentNo());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setString(3, object.getLastName());
            preparedStatement.setString(4, object.getAddress());
            preparedStatement.setString(5, object.getBirthday());
            preparedStatement.setString(6, object.getEmail());
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
    public void update(int id, Customer object) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setInt(1, object.getDocumentNo());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setString(3, object.getLastName());
            preparedStatement.setString(4, object.getAddress());
            preparedStatement.setString(5, object.getBirthday());
            preparedStatement.setString(6, object.getEmail());
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
    public List<Customer> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMER, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Customer> customers = new ArrayList<>();

            while (result.next()) {
                Customer customer =
                        new Customer(result.getInt("id"), result.getInt("document_no"), result.getString("name"), result.getString("last_name"),
                                result.getString("address"), result.getString("birthday"), result.getString("email"));
                customers.add(customer);

            }

            return customers;
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
    public Customer getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_CUSTOMER_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Customer customer = new Customer();
            customer.setId(result.getInt("id"));
            customer.setDocumentNo(result.getInt("document_no"));
            customer.setName(result.getString("name"));
            customer.setLastName(result.getString("last_name"));
            customer.setAddress(result.getString("address"));
            customer.setBirthday(result.getString("birthday"));
            customer.setEmail(result.getString("email"));

            return customer;
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
