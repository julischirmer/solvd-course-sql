package myBatis;

import models.RoleStaff;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface IRoleStaffDAO extends IDAO<RoleStaff> {
    void insert (RoleStaff object) throws SQLException;
    void update (@Param("object") RoleStaff object) throws SQLException;
    List<RoleStaff> getAll () throws SQLException;
    RoleStaff getById (int id) throws SQLException;
    void deleteById(int id) throws SQLException;

}
