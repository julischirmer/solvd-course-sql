package services;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceFactory {
    private static ServiceFactory instance;
    private static SqlSessionFactory factory;

    private static final Logger logger = LogManager.getLogger(ServiceFactory.class);

    private ServiceFactory() {
        String resource = "mybatis-config.xml";
        Reader configReader = null;
        try {
            configReader = Resources.getResourceAsReader(resource);
            factory = new SqlSessionFactoryBuilder().build(configReader);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public SqlSessionFactory getFactory() {
        return factory;
    }
}
