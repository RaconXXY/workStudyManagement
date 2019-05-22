package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.DiscountFeeDao;
import com.workstudy.ssm.model.DiscountFee;
import com.workstudy.ssm.service.DiscountFeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DiscountFeeServiceImpl implements DiscountFeeService {
    @Resource
    DiscountFeeDao discountFeeDao;
    @Override
    public Boolean checkTable(DiscountFee discountFee) {
        DiscountFee myTb = discountFeeDao.getTable(discountFee);
        if (null == myTb) {
            return false;
        }
        return true;
    }

    @Override
    public String createTable(DiscountFee discountFee) {
        if (!checkTable(discountFee)) {
            if (0 != discountFeeDao.createTable(discountFee)) {
                return "申请表登记成功！";
            }
            return "申请表登记失败！";
        }
        return "你已填写过此申请表！";
    }

    @Override
    public List<DiscountFee> getTableByStId(String studentId) {
        return discountFeeDao.getTableByStId(studentId);
    }

    @Override
    public String deleteTable(DiscountFee table) {
        if (checkTable(table)) {
            if (0 != discountFeeDao.deleteTable(table)) {
                return "申请表删除成功！";
            }
            return "申请表删除失败！";
        }
        return "未查询到该表";
    }

    @Override
    public String changeTable(String studentId, String tableYear, Integer result) {
        if (0 != discountFeeDao.changeTable(studentId, tableYear, result)) {
            return "申请表修改成功！";
        }
        return "申请表修改失败！";
    }

    @Override
    public List<DiscountFee> getAllTables() {
        return discountFeeDao.getAllTables();
    }

    @Override
    public String changeAdminRes(String studentId, String tableYear, Integer result) {
        if (0 != discountFeeDao.changeAdminRes(studentId, tableYear, result)) {
            return "申请表修改成功！";
        }
        return "申请表修改失败！";
    }

    @Override
    public String deleteTableByInfo(String studentId, String createdYear) {
        if (0 != discountFeeDao.deleteTableByInfo(studentId, createdYear)) {
            return "申请表删除成功！";
        }
        return "申请表删除失败！";
    }

    @Override
    public List<DiscountFee> getTablesByYear(String createdYear) {
        return discountFeeDao.getTablesByYear(createdYear);
    }
}
