package myBatis;

import models.Payment;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface IPaymentDAO extends IDAO<Payment> {
    void insert(Payment object) throws SQLException;

    void update(@Param("object") Payment object) throws SQLException;

    List<Payment> getAll() throws SQLException;

    Payment getById(int id) throws SQLException;

    void deleteById(int id) throws SQLException;

}
