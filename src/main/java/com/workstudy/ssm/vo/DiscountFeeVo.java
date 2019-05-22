package com.workstudy.ssm.vo;

/**
 * Created with IntelliJ IDEA
 * Created By fukaiqi
 * Date: 2017/8/18 0018
 * Time: 1:38
 */
public class DiscountFeeVo extends InfoVo {
    public static int lastRow = 3;       //excel有数据的最后一行，就是要填第一行的上面一行
    private String index;                //序号
    private String name;                 //姓名
    private String academy;              //学院
    private String className;            //班级
    private String studentId;            //学号
    private String sex;                  //性别
    private String isLoan;               //是否助学贷款
    private String awardsSumNumOfYear;   //学年奖励总额
    private String helpsSumNumOfYear;    //学年资助总额
    private String reason;               //申请认定理由
    private String isVery;               //是否特困
    private String discountNum;          //减免金额

    public DiscountFeeVo() {

        super(12);
    }

    @Override
    public String getDataField(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return index;
            case 1:
                return name;
            case 2:
                return academy;
            case 3:
                return className;
            case 4:
                return studentId;
            case 5:
                return sex;
            case 6:
                return isLoan;
            case 7:
                return awardsSumNumOfYear;
            case 8:
                return helpsSumNumOfYear;
            case 9:
                return reason;
            case 10:
                return isVery;
            case 11:
                return discountNum;

            default:
                return "";
        }
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(String isLoan) {
        this.isLoan = isLoan;
    }

    public String getAwardsSumNumOfYear() {
        return awardsSumNumOfYear;
    }

    public void setAwardsSumNumOfYear(String awardsSumNumOfYear) {
        this.awardsSumNumOfYear = awardsSumNumOfYear;
    }

    public String getHelpsSumNumOfYear() {
        return helpsSumNumOfYear;
    }

    public void setHelpsSumNumOfYear(String helpsSumNumOfYear) {
        this.helpsSumNumOfYear = helpsSumNumOfYear;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getIsVery() {
        return isVery;
    }

    public void setIsVery(String isVery) {
        this.isVery = isVery;
    }

    public String getDiscountNum() {
        return discountNum;
    }

    public void setDiscountNum(String discountNum) {
        this.discountNum = discountNum;
    }
}
