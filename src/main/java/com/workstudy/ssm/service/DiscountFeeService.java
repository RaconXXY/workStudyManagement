package com.workstudy.ssm.service;

import com.workstudy.ssm.model.DiscountFee;

import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
public interface DiscountFeeService {
    Boolean checkTable(DiscountFee discountFee);
    String createTable(DiscountFee discountFee);
    List<DiscountFee> getTableByStId (String studentId);
    String deleteTable(DiscountFee table);
    String changeTable(String studentId, String tableYear, Integer result);
    List<DiscountFee> getAllTables();
    String changeAdminRes(String studentId, String tableYear, Integer result);
    String deleteTableByInfo(String studentId, String createdYear);
    List<DiscountFee> getTablesByYear(String createdYear);
}
