package myBatis;

import models.Hall;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface IHallDAO extends IDAO<Hall> {
    void insert(Hall object) throws SQLException;

    void update(@Param("object") Hall object) throws SQLException;

    List<Hall> getAll() throws SQLException;

    Hall getById(int id) throws SQLException;

    void deleteById(int id) throws SQLException;

}
