package myBatis;

import models.Concert;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface IConcertDAO extends IDAO<Concert> {
    void insert (Concert object) throws SQLException;
    void update (@Param("object") Concert object) throws SQLException;
    List<Concert> getAll () throws SQLException;
    Concert getById (int id) throws SQLException;
    void deleteById(int id) throws SQLException;
}
