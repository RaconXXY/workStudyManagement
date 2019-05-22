package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.ScholarshipDao;
import com.workstudy.ssm.model.Scholarship;
import com.workstudy.ssm.service.ScholarshipService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/3.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ScholarshipServiceImpl implements ScholarshipService {
    @Resource
    private ScholarshipDao scholarshipDao;

    @Override
    public Boolean checkTable(Scholarship scholarship) {
        Scholarship myTb = scholarshipDao.getTable(scholarship);
        if (null == myTb) {
            return false;
        }
        return true;
    }

    @Override
    public String createTable(Scholarship scholarship) {
        if (!checkTable(scholarship)) {
            if (0 != scholarshipDao.createTable(scholarship)){
                return "申请表登记成功！";
            }
            return "申请表登记失败！";
        }
        return "你已填写过此申请表！";
    }

    @Override
    public List<Scholarship> getTableByStId(String studentId) {
        return scholarshipDao.getTableByStId(studentId);
    }

    @Override
    public String deleteTable(Scholarship table) {
        if (checkTable(table)) {
            if (0 != scholarshipDao.deleteTable(table)) {
                return "申请表删除成功！";
            }
            return "申请表删除失败！";
        }
        return "未查询到该表";
    }

    @Override
    public String changeTable(String studentId, String tableYear, Integer result) {
        if (0 != scholarshipDao.changeTable(studentId, tableYear, result)) {
            return "申请表修改成功！";
        }
        return "申请表修改失败！";
    }

    @Override
    public List<Scholarship> getAllTables() {
        return scholarshipDao.getAllTables();
    }

    @Override
    public String changeAdminRes(String studentId, String tableYear, Integer result) {
        if (0 != scholarshipDao.changeAdminRes(studentId, tableYear, result)) {
            return "申请表修改成功！";
        }
        return "申请表修改失败！";
    }

    @Override
    public String deleteTableByInfo(String studentId, String createdYear) {
        if (0 != scholarshipDao.deleteTableByInfo(studentId, createdYear)) {
            return "申请表删除成功！";
        }
        return "申请表删除失败！";
    }

    @Override
    public List<Scholarship> getTablesByYear(String createdYear) {
        return scholarshipDao.getTablesByYear(createdYear);
    }
}
