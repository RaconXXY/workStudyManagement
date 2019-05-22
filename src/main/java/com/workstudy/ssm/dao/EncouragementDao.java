package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.Encouragement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alander on 2017/8/3.
 */
@Repository
public interface EncouragementDao {
    Encouragement getTable(@Param("encouragement") Encouragement encouragement);
    Integer createTable(@Param("encouragement") Encouragement encouragement);
    List<Encouragement> getTableByStuId(@Param("studentId") String studentId);
    Integer deleteTable(@Param("encouragement") Encouragement encouragement);
    Integer changeTable(@Param("studentId") String studentId, @Param("tableYear") String tableYear, @Param("result") Integer result);
    List<Encouragement> getAllTables();
    Integer changeAdminRes(@Param("studentId") String studentId, @Param("tableYear") String tableYear, @Param("result") Integer result);

    Integer deleteTableByInfo(@Param("studentId") String studentId, @Param("tableYear") String tableYear);
    List<Encouragement> getTableByYear(@Param("createdYear") String createdYear);
}
