package myBatis;

import models.Instrument;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface IInstrumentDAO extends IDAO<Instrument> {
    void insert(Instrument object) throws SQLException;

    void update(@Param("object") Instrument object) throws SQLException;

    List<Instrument> getAll() throws SQLException;

    Instrument getById(int id) throws SQLException;

    void deleteById(int id) throws SQLException;

}
