package myBatis;

import dao.CountryDAO;
import dao.HallDAO;
import dao.IDAO;
import models.Country;
import models.Hall;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class MainMyBatis {
    private static final Logger logger = LogManager.getLogger(MainMyBatis.class);

    public static void main(String[] args) throws IOException, SQLException {
        try {

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();

            IDAO<Country> countryDAO = session.getMapper(IDAO.class);
            Country country = countryDAO.getById(1);

            logger.info("hall: " + country);

            session.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
