package com.workstudy.ssm.model;

/**
 * Created by Alander on 2017/8/13.
 */
public class Award {
    private String studentId;
    private String awardName;
    private Integer awardNumber;

    public Award(String studentId, String awardName, Integer awardNumber) {
        this.studentId = studentId;
        this.awardName = awardName;
        this.awardNumber = awardNumber;
    }

    public Award() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public Integer getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(Integer awardNumber) {
        this.awardNumber = awardNumber;
    }
}
