package myBatis;

import models.Staff;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface IStaffDAO extends IDAO<Staff> {
    void insert(Staff object) throws SQLException;

    void update(@Param("object") Staff object) throws SQLException;

    List<Staff> getAll() throws SQLException;

    Staff getById(int id) throws SQLException;

    void deleteById(int id) throws SQLException;

}
