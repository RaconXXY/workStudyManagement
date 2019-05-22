package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.ClassInfoDao;
import com.workstudy.ssm.model.ClassInfo;
import com.workstudy.ssm.service.ClassInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/1.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ClassInfoServiceImpl implements ClassInfoService {
    @Resource
    private ClassInfoDao classInfoDao;
    public List<ClassInfo> getAllAcademy() {
        return classInfoDao.getAllAcademy();
    }

    @Override
    public List<ClassInfo> getClassById(String teacherId) {
        return classInfoDao.getClassById(teacherId);
    }
}
