package dao;

import models.Customer;

import java.util.List;

public interface CustomerDAO {

    void insert (Customer customer);
    void delete (Customer customer);
    void modify (Customer customer);
    List<Customer> getAllCustomer (Customer customer);
    Customer getCustomer (Long id);

}
