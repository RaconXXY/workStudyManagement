package com.workstudy.ssm.model;

import java.util.List;

/**
 * Created by Alander on 2017/8/2.
 */
//国家奖学金申请表
public class Scholarship {
    private String studentId;
    private String tableYear;               //学年字段 YYYY-YYYY格式
    private String sex;                     //"男","女"
    private String birthYear;
    private String birthMonth;
    private String politicalStatus;         //政治面貌 "群众" "共青团员" "预备党员" "中共党员"
    private String nation;                  //民族 "汉族"
    private String startYear;               //入学年份
    private String startMonth;              //入学月份
    private String studyYears;              //学制 肆年
    private String phone;
    private String identityCardId;
    //学习情况
    private String grade;                   //成绩排名 名次/总人数
    private Integer courseNum;              //必修课门数
    private Integer passNum;                //及格门数
    private Integer rank;                   //是否实行综合考评排名
    private String reason;                  //申请认定理由
    private Integer teacherResult;          //教师评定结果 默认为-1 -1为未评定 0为不通过 1为通过
    private Integer adminResult;            //管理员评定结果

    private List<Prize> prizes;

    public Scholarship(String studentId, String tableYear, String sex, String birthYear, String birthMonth, String politicalStatus, String nation, String startYear, String startMonth, String studyYears, String phone, String identityCardId, String grade, Integer courseNum, Integer passNum, Integer rank, String reason, Integer teacherResult, Integer adminResult, List<Prize> prizes) {
        this.studentId = studentId;
        this.tableYear = tableYear;
        this.sex = sex;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.politicalStatus = politicalStatus;
        this.nation = nation;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.studyYears = studyYears;
        this.phone = phone;
        this.identityCardId = identityCardId;
        this.grade = grade;
        this.courseNum = courseNum;
        this.passNum = passNum;
        this.rank = rank;
        this.reason = reason;
        this.teacherResult = teacherResult;
        this.adminResult = adminResult;
        this.prizes = prizes;
    }

    public Scholarship() {
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
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

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
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

    public String getStudyYears() {
        return studyYears;
    }

    public void setStudyYears(String studyYears) {
        this.studyYears = studyYears;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }

    public Integer getPassNum() {
        return passNum;
    }

    public void setPassNum(Integer passNum) {
        this.passNum = passNum;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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
