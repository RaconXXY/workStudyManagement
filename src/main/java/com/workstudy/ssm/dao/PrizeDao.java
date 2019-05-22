package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.Prize;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
@Repository
public interface PrizeDao {
    Prize getTable(@Param("prize") Prize prize);
    Integer createTable(@Param("prize") Prize prize);
    List<Prize> getPrizesByStId(@Param("studentId") String studentId);

    void delPrizeByStId(@Param("studentId") String studentId);
}
