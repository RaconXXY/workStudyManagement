package com.workstudy.ssm.service;

import com.workstudy.ssm.model.StudentLib;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By fukaiqi
 * Date: 2017/8/19 0019
 * Time: 13:58
 */
public interface StudentLibService {
    boolean getItemById(String studentId, String tableYear);
    String createItem(StudentLib studentLib);
    String delItemById(String studentId, String tableYear);
    List<StudentLib> getAllTables();
    StudentLib getItem(String studentId, String createdYear);
    List<StudentLib> getTablesByYear(String tableYear);
}
