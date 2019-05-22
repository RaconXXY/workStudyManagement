package com.workstudy.ssm.service;

import com.workstudy.ssm.model.Stipend;

import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
public interface StipendService {
    Boolean checkTable(Stipend stipend);
    String createTable(Stipend stipend);
    List<Stipend> getTableByStId(String studentId);

    String deleteTable(Stipend table);
    String changeTable(String studentId, String tableYear, Integer result);
    List<Stipend> getAllTables();

    String changeAdminRes(String studentId, String tableYear, Integer result);

    String deleteTableByInfo(String studentId, String createdYear);
    List<Stipend> getTableByYear(String tableYear);
}
