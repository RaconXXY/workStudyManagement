package com.workstudy.ssm.service;

import com.workstudy.ssm.model.TimeControl;


/**
 * Created by Alander on 2017/9/10.
 */
public interface TimeControlService {
    Boolean dealTime ();
    Boolean createTime(TimeControl table);
    TimeControl getTime();
}
