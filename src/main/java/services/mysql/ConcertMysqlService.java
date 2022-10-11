package services.mysql;

import dao.ConcertDAO;
import models.Concert;
import services.IService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConcertMysqlService implements IService<Concert> {
    ConcertDAO concertDAO = new ConcertDAO();

    public ConcertMysqlService() throws SQLException {
    }

    @Override
    public void insert(Concert object) throws SQLException {
        concertDAO.insert(object);
    }

    @Override
    public void update(int id, Concert object) throws SQLException {
        concertDAO.update(id, object);
    }

    @Override
    public void update(Concert object) throws SQLException {

    }

    @Override
    public List<Concert> getAll() throws SQLException {
        ArrayList<Concert> concerts = (ArrayList<Concert>) concertDAO.getAll();
        return concerts;
    }

    @Override
    public Concert getById(int id) throws SQLException {
        Concert concert = concertDAO.getById(id);
        return concert;
    }

    @Override
    public void deleteById(int id) throws SQLException {
        concertDAO.deleteById(id);
    }
}
