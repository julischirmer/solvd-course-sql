package myBatis;

import models.Artist;
import models.Country;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface IArtistDAO extends IDAO<Artist> {
    void insert (Artist object) throws SQLException;
    void update (@Param("object") Artist object) throws SQLException;
    List<Artist> getAll () throws SQLException;
    Artist getById (int id) throws SQLException;
    void deleteById(int id) throws SQLException;
}
