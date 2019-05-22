package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.controller.TodoController;
import com.workstudy.ssm.dao.StipendDao;
import com.workstudy.ssm.model.Stipend;
import com.workstudy.ssm.service.StipendService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StipendServiceImpl implements StipendService {
    private Logger log = Logger.getLogger(TodoController.class);
    @Resource
    StipendDao stipendDao;

    @Override
    public Boolean checkTable(Stipend stipend) {
        Stipend myTb = stipendDao.getTable(stipend);
        if (null == myTb) {
            return false;
        }
        return true;
    }

    @Override
    public String createTable(Stipend stipend) {
        log.info(stipend.getStudentId());
        if (!checkTable(stipend)) {
            if (0 != stipendDao.createTable(stipend)) {
                return "申请表登记成功！";
            }
            return "申请表登记失败！";
        }
        return "你已填写过此申请表！";
    }

    @Override
    public List<Stipend> getTableByStId(String studentId) {
        return stipendDao.getTableByStId(studentId);
    }

    @Override
    public List<Stipend> getAllTables() {
        return stipendDao.getAllTables();
    }

    @Override
    public String deleteTable(Stipend table) {
        if (checkTable(table)) {
            if (0 != stipendDao.deleteTable(table)) {
                return "申请表删除成功！";
            }
            return "申请表删除失败！";
        }
        return "未查询到该表";
    }

    @Override
    public String changeTable(String studentId, String tableYear, Integer result) {
        if (0 != stipendDao.changeTable(studentId, tableYear, result)) {
            return "申请表修改成功！";
        }
        return "申请表修改失败！";
    }

    @Override
    public String changeAdminRes(String studentId, String tableYear, Integer result) {
        if (0 != stipendDao.changeAdminRes(studentId, tableYear, result)) {
            return "申请表修改成功！";
        }
        return "申请表修改失败！";
    }

    @Override
    public String deleteTableByInfo(String studentId, String createdYear) {
        if (0 != stipendDao.deleteTableByInfo(studentId, createdYear)) {
            return "申请表删除成功！";
        }
        return "申请表删除失败！";
    }

    @Override
    public List<Stipend> getTableByYear(String tableYear) {
        return stipendDao.getTableByYear(tableYear);
    }
}
