package com.workstudy.ssm.service;

import com.workstudy.ssm.model.ClassInfo;

import java.util.List;

/**
 * Created by Alander on 2017/8/1.
 */
public interface ClassInfoService {
    List<ClassInfo> getAllAcademy();
    List<ClassInfo> getClassById(String teacherId);
}
