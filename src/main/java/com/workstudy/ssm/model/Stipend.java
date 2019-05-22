package com.workstudy.ssm.model;

import java.util.List;

/**
 * Created by Alander on 2017/8/2.
 */
//国家助学金申请表
public class Stipend {
    private String studentId;
    private String tableYear;               //学年字段 YYYY-YYYY格式
    private String sex;                     //"男","女"
    private String birthYear;
    private String birthMonth;
    private String nation;                  //民族 "汉族"
    private String startYear;               //入学年份
    private String startMonth;              //入学月份
    private String politicalStatus;         //政治面貌 "群众" "共青团员" "预备党员" "中共党员"
    private String phone;
    private String identityCardId;          //身份证
    //家庭经济情况
    private Integer residence;              //家庭户口 0为城镇 1为农村
    private String incomeSource;            //收入来源
    private Integer incomePerMonth;          //家庭月总收入
    private Integer peopleNumber;
    private String address;
    private Integer postcode;               //邮编
    private String reason;                  //申请认定理由
    private Integer teacherResult;          //教师评定结果 默认为-1 -1为未评定 0未通过 1为一档 2为二档
    private Integer adminResult;            //管理员评定结果
    private List<FamilyMember> familyMembers;

    public Stipend(String studentId, String tableYear, String sex, String birthYear, String birthMonth, String nation, String startYear, String startMonth, String politicalStatus, String phone, String identityCardId, Integer residence, String incomeSource, Integer incomePerMonth, Integer peopleNumber, String address, Integer postcode, String reason, Integer teacherResult, Integer adminResult, List<FamilyMember> familyMembers) {
        this.studentId = studentId;
        this.tableYear = tableYear;
        this.sex = sex;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.nation = nation;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.politicalStatus = politicalStatus;
        this.phone = phone;
        this.identityCardId = identityCardId;
        this.residence = residence;
        this.incomeSource = incomeSource;
        this.incomePerMonth = incomePerMonth;
        this.peopleNumber = peopleNumber;
        this.address = address;
        this.postcode = postcode;
        this.reason = reason;
        this.teacherResult = teacherResult;
        this.adminResult = adminResult;
        this.familyMembers = familyMembers;
    }

    public Stipend() {
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTableYear() {
        return tableYear;
    }

    public void setTableYear(String tableYear) {
        this.tableYear = tableYear;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityCardId() {
        return identityCardId;
    }

    public void setIdentityCardId(String identityCardId) {
        this.identityCardId = identityCardId;
    }

    public Integer getResidence() {
        return residence;
    }

    public void setResidence(Integer residence) {
        this.residence = residence;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    public Integer getIncomePerMonth() {
        return incomePerMonth;
    }

    public void setIncomePerMonth(Integer incomePerMonth) {
        this.incomePerMonth = incomePerMonth;
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getTeacherResult() {
        return teacherResult;
    }

    public void setTeacherResult(Integer teacherResult) {
        this.teacherResult = teacherResult;
    }

    public Integer getAdminResult() {
        return adminResult;
    }

    public void setAdminResult(Integer adminResult) {
        this.adminResult = adminResult;
    }
}
