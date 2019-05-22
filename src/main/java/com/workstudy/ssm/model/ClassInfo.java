package com.workstudy.ssm.model;

/**
 * Created by Alander on 2017/8/1.
 */
public class ClassInfo {
    private String academy;
    private String major;
    private String className;
    private String teacherId;

    public ClassInfo() {
    }

    public ClassInfo(String academy, String major, String className, String teacherId) {
        this.academy = academy;
        this.major = major;
        this.className = className;
        this.teacherId = teacherId;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
