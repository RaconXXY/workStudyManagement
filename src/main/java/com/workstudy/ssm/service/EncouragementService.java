package com.workstudy.ssm.service;

import com.workstudy.ssm.model.Encouragement;

import java.util.List;

/**
 * Created by Alander on 2017/8/3.
 */
public interface EncouragementService {
    Boolean checkTable (Encouragement encouragement);
    String createTable (Encouragement encouragement);
    List<Encouragement> getTableByStId(String studentId);
    String delTable(Encouragement encouragement);
    String deleteTable(Encouragement table);
    String changeTable(String studentId, String tableYear, Integer result);
    List<Encouragement> getAllTables();
    String changeAdminRes(String studentId, String tableYear, Integer result);
    String deleteTableByInfo(String studentId, String createdYear);
    List<Encouragement> getTableByYear(String createdYear);
}
