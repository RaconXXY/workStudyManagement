package com.workstudy.ssm.model;

/**
 * Created by Alander on 2017/8/2.
 */

//励志生申请表
public class Admitapply {
    private String studentId;
    private String tableYear;               //学年字段 YYYY-YYYY格式
    private String sex;                     //"男","女"
    private String birthYear;
    private String birthMonth;
    private String nation;                  //民族 "汉族"
    private String politicalStatus;         //政治面貌 "群众" "共青团员" "预备党员" "中共党员"
    private String birthPlace;              //籍贯 填写到市级 "浙江省杭州市"
    private String phone;
    private Integer isContinue;             //是否继上年连续申请 0为否、1为是
    private String isRender;                //是否在校外租房 0为否、1为是
    private String workAndStudy;            //参加勤工助学活动情况
    private String socialActivity;          //参加公益活动情况
    private String finance;                 //依次为 国家励志奖学金 国家助学金 山大助学金 社会生助学金 临时困难补助 减免学费 其他
    private String otherFinance;            //获得其他资助情况
    private Integer financeNumber;          //本学年已获得资助金额
    private String reason;                  //申请认定理由
    private Integer teacherResult;          //教师评定结果 默认为-1 -1为未评定 0为不通过 1为一般困难 2为困难 3为特别困难
    private Integer adminResult;            //管理员评定结果

    public Admitapply(String studentId, String tableYear, String sex, String birthYear, String birthMonth, String nation, String politicalStatus, String birthPlace, String phone, Integer isContinue, String isRender, String workAndStudy, String socialActivity, String finance, String otherFinance, Integer financeNumber, String reason, Integer teacherResult, Integer adminResult) {
        this.studentId = studentId;
        this.tableYear = tableYear;
        this.sex = sex;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.nation = nation;
        this.politicalStatus = politicalStatus;
        this.birthPlace = birthPlace;
        this.phone = phone;
        this.isContinue = isContinue;
        this.isRender = isRender;
        this.workAndStudy = workAndStudy;
        this.socialActivity = socialActivity;
        this.finance = finance;
        this.otherFinance = otherFinance;
        this.financeNumber = financeNumber;
        this.reason = reason;
        this.teacherResult = teacherResult;
        this.adminResult = adminResult;
    }

    public Admitapply() {
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

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(Integer isContinue) {
        this.isContinue = isContinue;
    }

    public String getIsRender() {
        return isRender;
    }

    public void setIsRender(String isRender) {
        this.isRender = isRender;
    }

    public String getWorkAndStudy() {
        return workAndStudy;
    }

    public void setWorkAndStudy(String workAndStudy) {
        this.workAndStudy = workAndStudy;
    }

    public String getSocialActivity() {
        return socialActivity;
    }

    public void setSocialActivity(String socialActivity) {
        this.socialActivity = socialActivity;
    }

    public String getFinance() {
        return finance;
    }

    public void setFinance(String finance) {
        this.finance = finance;
    }

    public String getOtherFinance() {
        return otherFinance;
    }

    public void setOtherFinance(String otherFinance) {
        this.otherFinance = otherFinance;
    }

    public Integer getFinanceNumber() {
        return financeNumber;
    }

    public void setFinanceNumber(Integer financeNumber) {
        this.financeNumber = financeNumber;
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
