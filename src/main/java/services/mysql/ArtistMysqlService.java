package services.mysql;

import dao.ArtistDAO;
import dao.CountryDAO;
import models.Artist;
import models.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.IService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistMysqlService implements IService<Artist> {
    ArtistDAO artistDAO = new ArtistDAO();

    public ArtistMysqlService() throws SQLException {
    }

    @Override
    public void insert(Artist object) throws SQLException {
        artistDAO.insert(object);
    }

    @Override
    public void update(int id, Artist object) throws SQLException {
        artistDAO.update(id,object);
    }

    @Override
    public void update(Artist object) throws SQLException {

    }

    @Override
    public List<Artist> getAll() throws SQLException {
        ArrayList<Artist> artists = artistDAO.getAll();
        return artists;
    }

    @Override
    public Artist getById(int id) throws SQLException {
        Artist artist = artistDAO.getById(id);
        return artist;
    }

    @Override
    public void deleteById(int id) throws SQLException {
        artistDAO.deleteById(id);
    }
}
