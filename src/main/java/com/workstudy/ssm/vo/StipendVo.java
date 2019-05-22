package com.workstudy.ssm.vo;

/**
 * Created with IntelliJ IDEA
 * Created By fukaiqi
 * Date: 2017/8/18 0018
 * Time: 1:38
 */
public class StipendVo extends InfoVo {
    public static int lastRow = 8;       //excel有数据的最后一行，就是要填第一行的上面一行
    private String index;                //序号
    private String name;                 //姓名
    private String identityCardId;       //身份证号
    private String academy;              //学院
    private String major;                //专业
    private String studentId;            //学号
    private String sex;                  //性别
    private String nation;               //民族
    private String startYM;              //入学年月
    private String level;                //资助档次

    public StipendVo() {
        super(10);
    }

    @Override
    public String getDataField(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return index;
            case 1:
                return name;
            case 2:
                return identityCardId;
            case 3:
                return academy;
            case 4:
                return major;
            case 5:
                return studentId;
            case 6:
                return sex;
            case 7:
                return nation;
            case 8:
                return startYM;
            case 9:
                return level;

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

    public String getIdentityCardId() {
        return identityCardId;
    }

    public void setIdentityCardId(String identityCardId) {
        this.identityCardId = identityCardId;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getStartYM() {
        return startYM;
    }

    public void setStartYM(String startYM) {
        this.startYM = startYM;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
