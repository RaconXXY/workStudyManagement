package com.workstudy.ssm.service;

import com.workstudy.ssm.model.Prize;

import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
public interface PrizeService {
    Boolean checkTable(Prize prize);
    String createTable(Prize prize);
    List<Prize> getPrizesByStId (String studentId);
    void delPrizeByStId(String studentId);
}
