package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.FamilyMemberDao;
import com.workstudy.ssm.model.FamilyMember;
import com.workstudy.ssm.service.FamilyMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FamilyMemberServiceImpl implements FamilyMemberService {
    @Resource
    FamilyMemberDao familyMemberDao;

    @Override
    public Boolean checkTable(FamilyMember member) {
        FamilyMember myTb = familyMemberDao.getTable(member);
        if (null == myTb) {
            return false;
        }
        return true;
    }

    @Override
    public String createTable(FamilyMember member) {
        if (!checkTable(member)) {
            if (0 != familyMemberDao.createTable(member)) {
                return "申请表登记成功！";
            }
            return "申请表登记失败！";
        }
        return "你已填写过此申请表！";
    }

    @Override
    public void deleteMembersByStId(String studentId) {
        familyMemberDao.deleteMembersByStId(studentId);
    }

    @Override
    public List<FamilyMember> getMembersByStId(String studentId) {
        return familyMemberDao.getMembersByStId(studentId);
    }
}