package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.StudentLibDao;
import com.workstudy.ssm.model.StudentLib;
import com.workstudy.ssm.service.StudentLibService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By fukaiqi
 * Date: 2017/8/19 0019
 * Time: 13:58
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StudentLibServiceImpl implements StudentLibService{

    @Resource
    private StudentLibDao studentLibDao;

    @Override
    public boolean getItemById(String studentId, String tableYear) {
        return (studentLibDao.getItemById(studentId, tableYear) != null);
    }

    @Override
    public String createItem(StudentLib studentLib) {
        if (0 != studentLibDao.createItem(studentLib)) {
            return "插入成功！";
        }
        return "插入失败！";
    }

    @Override
    public String delItemById(String studentId, String tableYear) {
        if (0 != studentLibDao.delItemById(studentId, tableYear)) {
            return "删除成功！";
        }
        return "删除失败！";
    }

    @Override
    public List<StudentLib> getAllTables() {
        return studentLibDao.getAllTables();
    }

    @Override
    public StudentLib getItem(String studentId, String createdYear) {
        return studentLibDao.getItemById(studentId, createdYear);
    }

    @Override
    public List<StudentLib> getTablesByYear(String tableYear) {
        return studentLibDao.getTablesByYear(tableYear);
    }
}
