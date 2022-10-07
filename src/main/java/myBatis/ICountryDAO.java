package myBatis;

import models.Country;

import java.sql.SQLException;
import java.util.List;

public interface ICountryDAO {
    void insertCountry (Country object) throws SQLException;
    void updateCountry (int id, Country object) throws SQLException;
    List<Country> getAllCountry () throws SQLException;
    Country getByIdCountry (int id) throws SQLException;
    void deleteByIdCountry(int id) throws SQLException;
}
