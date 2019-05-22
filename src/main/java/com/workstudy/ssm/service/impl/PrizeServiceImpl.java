package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.PrizeDao;
import com.workstudy.ssm.model.Prize;
import com.workstudy.ssm.service.PrizeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PrizeServiceImpl implements PrizeService {
    @Resource
    private PrizeDao prizeDao;

    @Override
    public Boolean checkTable(Prize prize) {
        Prize myTb = prizeDao.getTable(prize);
        if (null == myTb) {
            return false;
        }
        return true;
    }

    @Override
    public String createTable(Prize prize) {
        if (!checkTable(prize)) {
            if (0 != prizeDao.createTable(prize)) {
                return "申请表登记成功！";
            }
            return "申请表登记失败！";
        }
        return "你已填写过此申请表！";
    }

    @Override
    public void delPrizeByStId(String studentId) {
        prizeDao.delPrizeByStId(studentId);
    }

    @Override
    public List<Prize> getPrizesByStId(String studentId) {
        return prizeDao.getPrizesByStId(studentId);
    }
}