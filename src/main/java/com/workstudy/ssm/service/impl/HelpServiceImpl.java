package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.HelpDao;
import com.workstudy.ssm.model.Help;
import com.workstudy.ssm.service.HelpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/13.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HelpServiceImpl implements HelpService {
    @Resource
    HelpDao helpDao;

    @Override
    public Boolean checkTable(Help help) {
        Help myTb = helpDao.getTable(help);
        if (null == myTb) {
            return false;
        }
        return true;
    }

    @Override
    public void deleteHelpByStId(String studentId) {
        helpDao.deleteHelpByStId(studentId);
    }

    @Override
    public String createTable(Help help) {
        if (!checkTable(help)) {
            if (0 != helpDao.createTable(help)) {
                return "申请表登记成功！";
            }
            return "申请表登记失败！";
        }
        return "你已填写过此申请表！";
    }

    @Override
    public List<Help> getHelpsByStId(String studentId) {
        return helpDao.getHelpsByStId(studentId);
    }
}