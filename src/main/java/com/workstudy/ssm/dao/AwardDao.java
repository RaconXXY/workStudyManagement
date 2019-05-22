package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.Award;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alander on 2017/8/13.
 */
@Repository
public interface AwardDao {
    Award getTable(@Param("award") Award award);
    Integer createTable(@Param("award") Award award);
    List<Award> getAwardsByStId(@Param("studentId") String studentId);

    void deleteAwardByStId(@Param("studentId") String studentId);
}
