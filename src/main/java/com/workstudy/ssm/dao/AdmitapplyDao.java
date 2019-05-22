package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.Admitapply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alander on 2017/8/3.
 */
@Repository
public interface AdmitapplyDao {
    Admitapply getTable(@Param("admitapply") Admitapply admitapply);
    Integer createTable(@Param("admitapply") Admitapply admitapply);
    List<Admitapply> getTableByStId(@Param("studentId") String studentId);
    Integer deleteTable(@Param("admitapply") Admitapply admitapply);
    Integer changeTable(@Param("studentId") String studentId, @Param("tableYear") String tableYear, @Param("result") Integer result);
    List<Admitapply> getAllTables();
    Integer changeAdminRes(@Param("studentId") String studentId, @Param("tableYear") String tableYear, @Param("result") Integer result);
    Integer deleteTableByInfo(@Param("studentId") String studentId, @Param("tableYear") String tableYear);

    Admitapply getTableByInfo(@Param("userId") String userId, @Param("tableYear") String tableYear);
}
