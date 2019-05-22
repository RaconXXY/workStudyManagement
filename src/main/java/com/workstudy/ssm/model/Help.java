package com.workstudy.ssm.model;

/**
 * Created by Alander on 2017/8/13.
 */
public class Help {
    private String studentId;
    private String helpName;
    private Integer helpNumber;

    public Help() {
    }

    public Help(String studentId, String helpName, Integer helpNumber) {

        this.studentId = studentId;
        this.helpName = helpName;
        this.helpNumber = helpNumber;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getHelpName() {
        return helpName;
    }

    public void setHelpName(String helpName) {
        this.helpName = helpName;
    }

    public Integer getHelpNumber() {
        return helpNumber;
    }

    public void setHelpNumber(Integer helpNumber) {
        this.helpNumber = helpNumber;
    }
}
