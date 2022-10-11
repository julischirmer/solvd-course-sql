package myBatis;

import models.Country;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface ICountryDAO extends IDAO<Country> {
    void insert(Country object) throws SQLException;

    void update(@Param("object") Country object) throws SQLException;

    List<Country> getAll() throws SQLException;

    Country getById(int id) throws SQLException;

    void deleteById(int id) throws SQLException;

}
