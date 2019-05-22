package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.ClassInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alander on 2017/8/1.
 */
@Repository
public interface ClassInfoDao {
    List<ClassInfo> getAllAcademy();
    List<ClassInfo> getClassById(@Param("teacherId") String teacherId);
}
