package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.StudentLib;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By fukaiqi
 * Date: 2017/8/19 0019
 * Time: 13:58
 */
@Repository
public interface StudentLibDao {
    Integer createItem(@Param("studentLib") StudentLib studentLib);
    StudentLib getItemById(@Param("studentId") String studentId, @Param("tableYear") String tableYear);
    Integer delItemById(@Param("studentId") String studentId, @Param("tableYear") String tableYear);
    List<StudentLib> getAllTables();

    List<StudentLib> getTablesByYear(@Param("tableYear") String tableYear);
}
