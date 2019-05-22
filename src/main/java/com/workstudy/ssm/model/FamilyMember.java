package com.workstudy.ssm.model;

/**
 * Created by Alander on 2017/8/2.
 */
//家庭成员情况表
public class FamilyMember {
    private String studentId;
    private String name;            //家属名字
    private Integer age;
    private String appellation;     //称谓
    private String workCeremony;   //工作学习单位
    private Integer health;         //健康情况 0为大病/重残、1为小病/轻残、2为健康
    private Integer study;          //在学情况。 0 为未在学、1为小学、2为初中、3为高中、4为大学（含研究生）

    public FamilyMember(String studentId, String name, Integer age, String appellation, String workCeremony, Integer health, Integer study) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.appellation = appellation;
        this.workCeremony = workCeremony;
        this.health = health;
        this.study = study;
    }

    public FamilyMember() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getWorkCeremony() {
        return workCeremony;
    }

    public void setWorkCeremony(String workCeremony) {
        this.workCeremony = workCeremony;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getStudy() {
        return study;
    }

    public void setStudy(Integer study) {
        this.study = study;
    }

    @Override
    public String toString() {
        return "studentId: "+studentId+", name: "+name+", age: "+age+", appellation: "+appellation+", work: " +workCeremony+
                "health: "+health+", study: "+study;
    }
}
