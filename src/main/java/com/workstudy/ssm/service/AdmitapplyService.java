package com.workstudy.ssm.service;

import com.workstudy.ssm.model.Admitapply;

import java.util.List;

/**
 * Created by Alander on 2017/8/3.
 */
public interface AdmitapplyService {
    Boolean checkTable (Admitapply admitapply);
    String createTable (Admitapply admitapply);
    List<Admitapply> getTableByStId (String studentId);
    String deleteTable (Admitapply admitapply);
    String changeTable(String studentId, String tableYear, Integer result);
    List<Admitapply> getAllTables();
    String changeAdminRes(String studentId, String tableYear, Integer result);
    String deleteTableByInfo(String studentId, String createdYear);

    Admitapply getTable(String userId, String tableYear);
}
