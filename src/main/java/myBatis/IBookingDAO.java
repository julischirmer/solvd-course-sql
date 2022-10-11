package myBatis;

import models.Booking;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface IBookingDAO extends IDAO<Booking> {
    void insert(Booking object) throws SQLException;

    void update(@Param("object") Booking object) throws SQLException;

    List<Booking> getAll() throws SQLException;

    Booking getById(int id) throws SQLException;

    void deleteById(int id) throws SQLException;

}
