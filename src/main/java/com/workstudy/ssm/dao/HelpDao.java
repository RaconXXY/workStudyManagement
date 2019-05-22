package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.Help;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alander on 2017/8/13.
 */
@Repository
public interface HelpDao {
    Help getTable(@Param("help") Help help);
    Integer createTable(@Param("help") Help help);
    List<Help> getHelpsByStId(@Param("studentId") String studentId);

    void deleteHelpByStId(@Param("studentId") String studentId);
}
