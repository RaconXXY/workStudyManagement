package com.workstudy.ssm.service;

import com.workstudy.ssm.model.FamilyMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
public interface FamilyMemberService {
    Boolean checkTable(FamilyMember member);
    String createTable(FamilyMember member);
    List<FamilyMember> getMembersByStId (String studentId);
    void deleteMembersByStId (String studentId);
}
