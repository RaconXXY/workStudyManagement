package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.EncouragementDao;
import com.workstudy.ssm.model.Encouragement;
import com.workstudy.ssm.service.EncouragementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/3.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EncouragementServiceImpl implements EncouragementService {

    @Resource
    private EncouragementDao encouragementDao;

    @Override
    public Boolean checkTable(Encouragement encouragement) {
        Encouragement myTb = encouragementDao.getTable(encouragement);
        if (null == myTb) {
            return false;
        }
        return true;
    }

    @Override
    public String createTable(Encouragement encouragement) {
        if (!checkTable(encouragement)) {
            if (0 != encouragementDao.createTable(encouragement)) {
                return "申请表登记成功！";
            }
            return "申请表登记失败！";
        }
        return "你已填写过此申请表！";
    }

    @Override
    public List<Encouragement> getTableByStId(String studentId) {
        return encouragementDao.getTableByStuId(studentId);
    }

    @Override
    public List<Encouragement> getAllTables() {
        return encouragementDao.getAllTables();
    }

    @Override
    public String delTable(Encouragement encouragement) {
        if (checkTable(encouragement)) {
            if (0 != encouragementDao.deleteTable(encouragement)) {
                return "申请表删除成功！";
            }
            return "申请表删除失败！";
        }
        return "未查询到该表";
    }

    @Override
    public String deleteTable(Encouragement table) {
        if (checkTable(table)) {
            if (0 != encouragementDao.deleteTable(table)) {
                return "申请表删除成功！";
            }
            return "申请表删除失败！";
        }
        return "未查询到该表";
    }

    @Override
    public String changeTable(String studentId, String tableYear, Integer result) {
        if (0 != encouragementDao.changeTable(studentId, tableYear, result)) {
            return "申请表修改成功！";
        }
        return "申请表修改失败！";
    }

    @Override
    public String changeAdminRes(String studentId, String tableYear, Integer result) {
        if (0 != encouragementDao.changeAdminRes(studentId, tableYear, result)) {
            return "申请表修改成功！";
        }
        return "申请表修改失败！";
    }

    @Override
    public String deleteTableByInfo(String studentId, String createdYear) {
        if (0 != encouragementDao.deleteTableByInfo(studentId, createdYear)) {
            return "申请表删除成功！";
        }
        return "申请表删除失败！";
    }

    @Override
    public List<Encouragement> getTableByYear(String createdYear) {
        return encouragementDao.getTableByYear(createdYear);
    }
}
