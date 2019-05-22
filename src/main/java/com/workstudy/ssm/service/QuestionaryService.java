package com.workstudy.ssm.service;

import com.workstudy.ssm.model.Admitapply;
import com.workstudy.ssm.model.Questionary;

import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
public interface QuestionaryService {
    Boolean checkTable(Questionary questionary);
    String createTable(Questionary questionary);
    List<Questionary> getTableByStId(String studentId);
    String deleteTable(Questionary table);
    Questionary getTable(String studentId, String createdYear);
}
