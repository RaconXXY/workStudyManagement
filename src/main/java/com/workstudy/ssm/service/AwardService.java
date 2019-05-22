package com.workstudy.ssm.service;

import com.workstudy.ssm.model.Award;

import java.util.List;

/**
 * Created by Alander on 2017/8/13.
 */
public interface AwardService {
    Boolean checkTable(Award award);
    String createTable(Award award);
    List<Award> getAwardsByStId(String studentId);
    void deleteAwardByStId (String studentId);
}
