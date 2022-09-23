package dao;

import java.util.List;

public interface IDAO<T> {

    void insert (T c);
    void delete (T c);
    void modify (T c);
    List<T> getAllCustomer (T c);
    T getCustomer (Long id);
}
