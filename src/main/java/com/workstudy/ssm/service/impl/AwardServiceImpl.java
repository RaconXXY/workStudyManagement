package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.AwardDao;
import com.workstudy.ssm.model.Award;
import com.workstudy.ssm.service.AwardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/13.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AwardServiceImpl implements AwardService {
    @Resource
    AwardDao awardDao;

    @Override
    public void deleteAwardByStId(String studentId) {
        awardDao.deleteAwardByStId(studentId);
    }

    @Override
    public Boolean checkTable(Award award) {
        Award myTb = awardDao.getTable(award);
        if (null == myTb) {
            return false;
        }
        return true;
    }

    @Override
    public String createTable(Award award) {
        if (!checkTable(award)) {
            if (0 != awardDao.createTable(award)) {
                return "申请表登记成功！";
            }
            return "申请表登记失败！";
        }
        return "你已填写过此申请表！";
    }

    @Override
    public List<Award> getAwardsByStId(String studentId) {
        return awardDao.getAwardsByStId(studentId);
    }
}