package myBatis;

import models.Ticket;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface ITicketDAO extends IDAO<Ticket> {
    void insert (Ticket object) throws SQLException;
    void update (@Param("object") Ticket object) throws SQLException;
    List<Ticket> getAll () throws SQLException;
    Ticket getById (int id) throws SQLException;
    void deleteById(int id) throws SQLException;

}
