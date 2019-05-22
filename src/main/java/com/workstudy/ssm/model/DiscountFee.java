package com.workstudy.ssm.model;

import java.util.List;

/**
 * Created by Alander on 2017/8/2.
 */
//学费减免申请表
public class DiscountFee {
    private String studentId;
    private String tableYear;               //学年字段 YYYY-YYYY格式
    private String sex;                     //"男","女"
    private String birthYear;
    private String birthMonth;
    private String nation;                  //民族 "汉族"
    private String politicalStatus;         //政治面貌 "群众" "共青团员" "预备党员" "中共党员"
    private String phone;
    //家庭经济情况
    private Integer residence;              //家庭户口 0为城镇 1为农村
    private String incomeSource;            //收入来源
    private Integer incomePerMonth;          //家庭月总收入
    private Integer peopleNumber;
    private Integer isLoan;                 //是否助学贷款
    private String reason;                  //申请认定理由
    private Integer teacherResult;          //教师评定结果 默认为-1 -1为未评定 0为不通过 其他为金额
    private Integer adminResult;            //管理员评定结果
    private List<Award> awards;
    private List<Help> helps;

    public DiscountFee(String studentId, String tableYear, String sex, String birthYear, String birthMonth, String nation, String politicalStatus, String phone, Integer residence, String incomeSource, Integer incomePerMonth, Integer peopleNumber, Integer isLoan, String reason, Integer teacherResult, Integer adminResult, List<Award> awards, List<Help> helps) {
        this.studentId = studentId;
        this.tableYear = tableYear;
        this.sex = sex;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.nation = nation;
        this.politicalStatus = politicalStatus;
        this.phone = phone;
        this.residence = residence;
        this.incomeSource = incomeSource;
        this.incomePerMonth = incomePerMonth;
        this.peopleNumber = peopleNumber;
        this.isLoan = isLoan;
        this.reason = reason;
        this.teacherResult = teacherResult;
        this.adminResult = adminResult;
        this.awards = awards;
        this.helps = helps;
    }

    public DiscountFee() {
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    public List<Help> getHelps() {
        return helps;
    }

    public void setHelps(List<Help> helps) {
        this.helps = helps;
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

    public Integer getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(Integer isLoan) {
        this.isLoan = isLoan;
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
