package com.workstudy.ssm.service;

import com.workstudy.ssm.model.Scholarship;

import java.util.List;

/**
 * Created by Alander on 2017/8/3.
 */
public interface ScholarshipService {
    Boolean checkTable(Scholarship scholarship);
    String createTable(Scholarship scholarship);
    List<Scholarship> getTableByStId(String studentId);
    String deleteTable(Scholarship table);
    String changeTable(String studentId, String tableYear, Integer result);
    List<Scholarship> getAllTables();

    String changeAdminRes(String studentId, String tableYear, Integer result);

    String deleteTableByInfo(String studentId, String createdYear);
    List<Scholarship> getTablesByYear(String createdYear);
}
