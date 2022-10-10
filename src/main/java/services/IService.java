package services;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {

    void insert (T object) throws SQLException;
    void update (int id, T object) throws SQLException;
    void update ( T object) throws SQLException;
    List<T> getAll () throws SQLException;
    T getById (int id) throws SQLException;
    void deleteById(int id) throws SQLException;
}