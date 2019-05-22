package com.workstudy.ssm.model;

//励志生汇总表
public class StudentLib {
    private String studentId;
    private String tableYear;            //学年字段 YYYY-YYYY格式
    private Integer isLoan;              //本年度是否申请国家贷款
    private Integer isWorkAndStudy;      //本年度是否有勤工助学
    private String awardsName = "";      //本年度获得奖励情况
    private String awardsNumber = "";    //本年度获得奖励总额
    private String helpsName = "";       //本年度获得资助情况
    private String helpsNumber = "";     //本年度获得资助总额
    private String other;                //备注
    private Integer isCheckin;           //是否已录入信息（excel部分需要管理员录入的内容）

    public StudentLib(String studentId, String tableYear, Integer isLoan, Integer isWorkAndStudy, String awardsName, String awardsNumber, String helpsName, String helpsNumber, String other, Integer isCheckin) {
        this.studentId = studentId;
        this.tableYear = tableYear;
        this.isLoan = isLoan;
        this.isWorkAndStudy = isWorkAndStudy;
        this.awardsName = awardsName;
        this.awardsNumber = awardsNumber;
        this.helpsName = helpsName;
        this.helpsNumber = helpsNumber;
        this.other = other;
        this.isCheckin = isCheckin;
    }

    public StudentLib() {
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

    public Integer getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(Integer isLoan) {
        this.isLoan = isLoan;
    }

    public Integer getIsWorkAndStudy() {
        return isWorkAndStudy;
    }

    public void setIsWorkAndStudy(Integer isWorkAndStudy) {
        this.isWorkAndStudy = isWorkAndStudy;
    }

    public String getAwardsName() {
        return awardsName;
    }

    public void setAwardsName(String awardsName) {
        this.awardsName = awardsName;
    }

    public String getAwardsNumber() {
        return awardsNumber;
    }

    public void setAwardsNumber(String awardsNumber) {
        this.awardsNumber = awardsNumber;
    }

    public String getHelpsName() {
        return helpsName;
    }

    public void setHelpsName(String helpsName) {
        this.helpsName = helpsName;
    }

    public String getHelpsNumber() {
        return helpsNumber;
    }

    public void setHelpsNumber(String helpsNumber) {
        this.helpsNumber = helpsNumber;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Integer getIsCheckin() {
        return isCheckin;
    }

    public void setIsCheckin(Integer isCheckin) {
        this.isCheckin = isCheckin;
    }
}
