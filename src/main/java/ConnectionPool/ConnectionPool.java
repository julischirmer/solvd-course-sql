package ConnectionPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;
    private final String DRIVER;
    private final String URL;
    private final String USER;
    private final String PASS;
    private final int MAX_SIZE;
    private final AtomicInteger actualSize = new AtomicInteger(0);
    private final BlockingQueue<Connection> connectionPool;

    private ConnectionPool() {
        Properties properties = new Properties();
        try {
            System.out.println(System.getProperty("user.dir"));
            FileInputStream file = new FileInputStream("src/main/resources/sqlconfig.properties");
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("JDBC Properties file not found");
            //LOGGER.error("JDBC Properties file not found");
        }

        DRIVER = properties.getProperty("driver");
        URL = properties.getProperty("url");
        USER = properties.getProperty("user");
        PASS = properties.getProperty("pass");
        MAX_SIZE = Integer.parseInt(properties.getProperty("pool_size"));

        connectionPool = new ArrayBlockingQueue<>(MAX_SIZE);
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error(e);
            logger.error("JDBC implementation not found");
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        if (actualSize.get() < MAX_SIZE) {
            try {
                connectionPool.add(DriverManager.getConnection(URL, USER, PASS));
                actualSize.incrementAndGet();
            } catch (SQLException e) {
                logger.error(e);
                logger.error("Something went wrong when getting a connection");
            }
        }
        try {
            Connection connection = connectionPool.take();
            return connection;
        } catch (InterruptedException e) {
            logger.error("Thread interrupted");
            return null;
        }
    }

    public void releaseConnection(Connection connection) {
        connectionPool.add(connection);
    }

    public void closeAll() throws SQLException, InterruptedException {
        while (actualSize.get() > 0) {
            Connection connection = connectionPool.take();
            connection.close();
            actualSize.decrementAndGet();
        }
    }
}