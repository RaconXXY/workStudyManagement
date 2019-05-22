package com.workstudy.ssm.model;

/**
 * Created by Alander on 2017/8/2.
 */
//获奖情况表
public class Prize {
    private String studentId;
    private String date;         //获奖日期
    private String priceName;
    private String awardCeremony;

    public Prize(String studentId, String date, String priceName, String awardCeremony) {
        this.studentId = studentId;
        this.date = date;
        this.priceName = priceName;
        this.awardCeremony = awardCeremony;
    }

    public Prize() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public String getAwardCeremony() {
        return awardCeremony;
    }

    public void setAwardCeremony(String awardCeremony) {
        this.awardCeremony = awardCeremony;
    }
}
