package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.TimeControlDao;
import com.workstudy.ssm.model.TimeControl;
import com.workstudy.ssm.service.TimeControlService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Alander on 2017/9/10.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class TimeControlServiceImpl implements TimeControlService {
    @Resource
    TimeControlDao timeControlDao;

    @Override
    public Boolean dealTime() {
        if (null == timeControlDao.getTime()) {
            return true;
        }
        if (0 != timeControlDao.delTime()) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean createTime(TimeControl table) {
        if (0 != timeControlDao.createTime(table)) {
            return true;
        }
        return false;
    }

    @Override
    public TimeControl getTime() {
        return timeControlDao.getTime();
    }
}
