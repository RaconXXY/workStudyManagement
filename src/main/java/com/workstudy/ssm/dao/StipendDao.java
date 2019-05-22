package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.Stipend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
@Repository
public interface StipendDao {
    Stipend getTable(@Param("stipend") Stipend stipend);
    Integer createTable(@Param("stipend") Stipend stipend);
    List<Stipend> getTableByStId(@Param("studentId") String studentId);
    Integer deleteTable(@Param("stipend") Stipend stipend);
    Integer changeTable(@Param("studentId") String studentId, @Param("tableYear") String tableYear, @Param("result") Integer result);

    List<Stipend> getAllTables();

    Integer changeAdminRes(@Param("studentId") String studentId, @Param("tableYear") String tableYear, @Param("result") Integer result);

    Integer deleteTableByInfo(@Param("studentId") String studentId, @Param("tableYear") String tableYear);
    List<Stipend> getTableByYear(@Param("tableYear") String tableYear);
}
