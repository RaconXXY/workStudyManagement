package com.workstudy.ssm.service;

import com.workstudy.ssm.model.Help;

import java.util.List;

/**
 * Created by Alander on 2017/8/13.
 */
public interface HelpService {
    Boolean checkTable(Help help);
    String createTable(Help help);
    List<Help> getHelpsByStId (String studentId);
    void deleteHelpByStId (String studentId);
}
