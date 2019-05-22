package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.Questionary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
@Repository
public interface QuestionaryDao {
    Questionary getTable(@Param("questionary") Questionary questionary);
    Integer createTable(@Param("questionary") Questionary questionary);
    List<Questionary> getTableByStId(@Param("studentId") String studentId);
    Integer deleteTable(@Param("questionary") Questionary questionary);
    Questionary getTableByInfo(@Param("studentId") String studentId, @Param("createdYear") String createdYear);
}
