package myBatis;

import models.Customer;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO extends IDAO<Customer> {
    void insert(Customer object) throws SQLException;

    void update(@Param("object") Customer object) throws SQLException;

    List<Customer> getAll() throws SQLException;

    Customer getById(int id) throws SQLException;

    void deleteById(int id) throws SQLException;

}
