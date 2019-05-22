package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.QuestionaryDao;
import com.workstudy.ssm.model.Admitapply;
import com.workstudy.ssm.model.Questionary;
import com.workstudy.ssm.service.QuestionaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class QuestionaryServiceImpl implements QuestionaryService {
    @Resource
    QuestionaryDao questionaryDao;
    @Override
    public Boolean checkTable(Questionary questionary) {
        Questionary myTb = questionaryDao.getTable(questionary);
        if (null == myTb) {
            return false;
        }
        return true;
    }

    @Override
    public String createTable(Questionary questionary) {
        if (!checkTable(questionary)) {
            if (0 != questionaryDao.createTable(questionary)){
                return "申请表登记成功！";
            }
            return "申请表登记失败！";
        }
        return "你已填写过此申请表！";
    }

    @Override
    public List<Questionary> getTableByStId(String studentId) {
        return questionaryDao.getTableByStId(studentId);
    }

    @Override
    public String deleteTable(Questionary table) {
        if (checkTable(table)) {
            if (0 != questionaryDao.deleteTable(table)) {
                return "申请表删除成功！";
            }
            return "申请表删除失败！";
        }
        return "未查询到该表";
    }

    @Override
    public Questionary getTable(String studentId, String createdYear) {
        return questionaryDao.getTableByInfo(studentId, createdYear);
    }
}
