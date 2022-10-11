package services.mybatis;

import models.Artist;
import myBatis.IArtistDAO;
import org.apache.ibatis.session.SqlSession;
import services.IService;
import services.ServiceFactory;

import java.sql.SQLException;
import java.util.List;

public class ArtistMyBatisService implements IService<Artist> {

    @Override
    public void insert(Artist object) throws SQLException {
        SqlSession session = ServiceFactory.getInstance().getFactory().openSession();
        IArtistDAO artistDAO = session.getMapper(IArtistDAO.class);
        artistDAO.insert(object);
        session.commit();

    }

    @Override
    public void update(int id, Artist object) throws SQLException {

    }

    @Override
    public void update(Artist object) throws SQLException {
        SqlSession session = ServiceFactory.getInstance().getFactory().openSession();
        IArtistDAO artistDAO = session.getMapper(IArtistDAO.class);
        artistDAO.update(object);
        session.commit();
    }

    @Override
    public List<Artist> getAll() throws SQLException {
        List<Artist> artists = null;
        SqlSession session = ServiceFactory.getInstance().getFactory().openSession();
        IArtistDAO artistDAO = session.getMapper(IArtistDAO.class);
        artists = artistDAO.getAll();
        session.commit();

        return artists;
    }

    @Override
    public Artist getById(int id) throws SQLException {
        Artist artist = null;
        SqlSession session = ServiceFactory.getInstance().getFactory().openSession();
        IArtistDAO artistDAO = session.getMapper(IArtistDAO.class);
        artist = artistDAO.getById(id);
        session.commit();
        return artist;
    }

    @Override
    public void deleteById(int id) throws SQLException {
        SqlSession session = ServiceFactory.getInstance().getFactory().openSession();
        IArtistDAO artistDAO = session.getMapper(IArtistDAO.class);
        artistDAO.deleteById(id);
        session.commit();
    }
}
