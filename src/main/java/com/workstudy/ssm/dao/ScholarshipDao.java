package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.Scholarship;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alander on 2017/8/3.
 */
@Repository
public interface ScholarshipDao {
    Scholarship getTable(@Param("scholarship") Scholarship scholarship);
    Integer createTable(@Param("scholarship") Scholarship scholarship);
    List<Scholarship> getTableByStId(@Param("studentId") String studentId);
    Integer deleteTable(@Param("scholarship") Scholarship scholarship);
    Integer changeTable(@Param("studentId") String studentId, @Param("tableYear") String tableYear, @Param("result") Integer result);
    List<Scholarship> getAllTables();
    Integer changeAdminRes(@Param("studentId") String studentId, @Param("tableYear") String tableYear, @Param("result") Integer result);

    Integer deleteTableByInfo(@Param("studentId") String studentId, @Param("tableYear") String tableYear);
    List<Scholarship> getTablesByYear(@Param("createdYear") String createdYear);
}
