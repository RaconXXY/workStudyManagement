package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.TimeControl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Alander on 2017/9/10.
 */
@Repository
public interface TimeControlDao {
    int delTime();
    int createTime(@Param("table") TimeControl table);
    TimeControl getTime();
}
