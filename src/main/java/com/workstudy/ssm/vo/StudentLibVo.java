package com.workstudy.ssm.vo;

/**
 * Created with IntelliJ IDEA
 * Created By fukaiqi
 * Date: 2017/8/18 0018
 * Time: 1:38
 */
public class StudentLibVo extends InfoVo {
    public static int lastRow = 2;       //excel有数据的最后一行，就是要填第一行的上面一行
    private String index;                //序号
    private String academy;              //学院
    private String name;                 //姓名
    private String sex;                  //性别
    private String majorAndClassName;    //专业班级
    private String studentId;            //学号
    private String identityCardId;       //身份证号
    private String address;              //生源地
    private String isLoan;               //是否申请国家贷款
    private String isWorkAndStudy;       //是否有勤工助学
    private String awardsName = "";      //本年度获得奖励情况
    private String awardsNumber = "";    //本年度获得奖励总额
    private String helpsName = "";       //本年度获得资助情况
    private String helpsNumber = "";     //本年度获得资助总额
    private String familySummary;        //家庭情况简介
    private String isVery;               //是否特困生
    private String phone;                //电话
    private String other;                //备注


    public StudentLibVo() {
        super(18);
    }

    @Override
    public String getDataField(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return index;
            case 1:
                return academy;
            case 2:
                return name;
            case 3:
                return sex;
            case 4:
                return majorAndClassName;
            case 5:
                return studentId;
            case 6:
                return identityCardId;
            case 7:
                return address;
            case 8:
                return isLoan;
            case 9:
                return isWorkAndStudy;
            case 10:
                return awardsName;
            case 11:
                return awardsNumber;
            case 12:
                return helpsName;
            case 13:
                return helpsNumber;
            case 14:
                return familySummary;
            case 15:
                return isVery;
            case 16:
                return phone;
            case 17:
                return other;

            default:
                return "";
        }

    }

    public static int getLastRow() {
        return lastRow;
    }

    public static void setLastRow(int lastRow) {
        StudentLibVo.lastRow = lastRow;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajorAndClassName() {
        return majorAndClassName;
    }

    public void setMajorAndClassName(String majorAndClassName) {
        this.majorAndClassName = majorAndClassName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getIdentityCardId() {
        return identityCardId;
    }

    public void setIdentityCardId(String identityCardId) {
        this.identityCardId = identityCardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(String isLoan) {
        this.isLoan = isLoan;
    }

    public String getIsWorkAndStudy() {
        return isWorkAndStudy;
    }

    public void setIsWorkAndStudy(String isWorkAndStudy) {
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

    public String getFamilySummary() {
        return familySummary;
    }

    public void setFamilySummary(String familySummary) {
        this.familySummary = familySummary;
    }

    public String getIsVery() {
        return isVery;
    }

    public void setIsVery(String isVery) {
        this.isVery = isVery;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
