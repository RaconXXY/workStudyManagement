package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.AdmitapplyDao;
import com.workstudy.ssm.model.Admitapply;
import com.workstudy.ssm.service.AdmitapplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/3.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AdmitapplyServiceImpl implements AdmitapplyService {
    @Resource
    private AdmitapplyDao admitapplyDao;

    @Override
    public Boolean checkTable(Admitapply admitapply) {
        Admitapply myTb = admitapplyDao.getTable(admitapply);
        if (myTb == null) {
            return false;
        }
        return true;
    }

    @Override
    public String createTable(Admitapply admitapply) {
        if (!checkTable(admitapply)) {
            if (0 != admitapplyDao.createTable(admitapply)) {
                return "申请表登记成功！";
            }
            return "申请表登记失败！";
        }
        return "你已填写过此申请表！";
    }

    @Override
    public List<Admitapply> getTableByStId(String studentId) {
        return admitapplyDao.getTableByStId(studentId);
    }

    @Override
    public String deleteTable(Admitapply admitapply) {
        if (checkTable(admitapply)) {
            if (0 != admitapplyDao.deleteTable(admitapply)) {
                return "申请表删除成功！";
            }
            return "申请表删除失败！";
        }
        return "未查询到该表";
    }

    @Override
    public String changeTable(String studentId, String tableYear, Integer result) {
        if (0 != admitapplyDao.changeTable(studentId, tableYear, result)) {
            return "申请表修改成功！";
        }
        return "申请表修改失败！";
    }

    @Override
    public String changeAdminRes(String studentId, String tableYear, Integer result) {
        if (0 != admitapplyDao.changeAdminRes(studentId, tableYear, result)) {
            return "申请表修改成功！";
        }
        return "申请表修改失败！";
    }

    @Override
    public List<Admitapply> getAllTables() {
        return admitapplyDao.getAllTables();
    }

    @Override
    public String deleteTableByInfo(String studentId, String createdYear) {
        if (0 != admitapplyDao.deleteTableByInfo(studentId, createdYear)) {

            return "申请表删除成功！";
        }
        return "申请表删除失败！";
    }

    @Override
    public Admitapply getTable(String userId, String tableYear) {
        return admitapplyDao.getTableByInfo(userId, tableYear);
    }
}
