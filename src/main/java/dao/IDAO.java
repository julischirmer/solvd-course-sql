package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {

    void insert (T object) throws SQLException;
    void delete (T object) throws SQLException;
    void update (T object) throws SQLException;
    List<T> getAll (T object) throws SQLException;
    T getById (int id) throws SQLException;
}
