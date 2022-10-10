package services.mybatis;

import models.Artist;
import models.Concert;
import myBatis.IArtistDAO;
import myBatis.IConcertDAO;
import myBatis.ICountryDAO;
import myBatis.IDAO;
import org.apache.ibatis.session.SqlSession;
import services.IService;
import services.ServiceFactory;

import java.sql.SQLException;
import java.util.List;

public class ConcertMyBatisService implements IService<Concert> {
    @Override
    public void insert(Concert object) throws SQLException {
        SqlSession session = ServiceFactory.getInstance().getFactory().openSession();
        IConcertDAO concertDAO = session.getMapper(IConcertDAO.class);
        concertDAO.insert(object);
        session.commit();
    }

    @Override
    public void update(int id, Concert object) throws SQLException {

    }

    @Override
    public void update(Concert object) throws SQLException {
        SqlSession session = ServiceFactory.getInstance().getFactory().openSession();
        IConcertDAO concertDAO = session.getMapper(IConcertDAO.class);
        concertDAO.update(object);
        session.commit();
    }

    @Override
    public List<Concert> getAll() throws SQLException {
        List<Concert> concerts = null;
        SqlSession session = ServiceFactory.getInstance().getFactory().openSession();
        IConcertDAO concertDAO = session.getMapper(IConcertDAO.class);
        concerts = concertDAO.getAll();
        session.commit();

        return concerts;
    }

    @Override
    public Concert getById(int id) throws SQLException {
        Concert concert = null;
        SqlSession session = ServiceFactory.getInstance().getFactory().openSession();
        IConcertDAO concertDAO = session.getMapper(IConcertDAO.class);
        concert = concertDAO.getById(id);
        session.commit();
        return concert;
    }

    @Override
    public void deleteById(int id) throws SQLException {
        SqlSession session = ServiceFactory.getInstance().getFactory().openSession();
        IConcertDAO concertDAO = session.getMapper(IConcertDAO.class);
        concertDAO.deleteById(id);
        session.commit();
    }
}
