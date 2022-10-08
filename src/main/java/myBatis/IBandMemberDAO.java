package myBatis;

import models.BandMember;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface IBandMemberDAO extends IDAO<BandMember> {
    void insert (BandMember object) throws SQLException;
    void update (@Param("object") BandMember object) throws SQLException;
    List<BandMember> getAll () throws SQLException;
    BandMember getById (int id) throws SQLException;
    void deleteById(int id) throws SQLException;
}

