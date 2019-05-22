package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.FamilyMember;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
@Repository
public interface FamilyMemberDao {
    FamilyMember getTable(@Param("member") FamilyMember member);
    Integer createTable(@Param("member") FamilyMember member);
    List<FamilyMember> getMembersByStId(@Param("studentId") String studentId);

    void deleteMembersByStId(@Param("studentId") String studentId);
}
