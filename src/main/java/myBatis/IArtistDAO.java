package myBatis;

import models.Artist;
import models.Country;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface IArtistDAO {
    void insertArtist (Artist object) throws SQLException;
    void updateArtist (@Param("id") int id, @Param("object") Artist object) throws SQLException;
    List<Country> getAllArtist () throws SQLException;
    Country getByIdArtist (int id) throws SQLException;
    void deleteByIdArtist(int id) throws SQLException;
}
