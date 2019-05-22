package com.workstudy.ssm.model;

/**
 * Created by Alander on 2017/9/10.
 */
public class TimeControl {
    private Integer admitApplyTeacher;
    private Integer stipendTeacher;
    private Integer encouragementTeacher;
    private Integer scholarshipTeacher;
    private Integer discountFeeTeacher;
    private Integer admitApplySt;
    private Integer questionarySt;
    private Integer stipendSt;
    private Integer encouragementSt;
    private Integer scholarshipSt;
    private Integer discountFeeSt;

    public TimeControl() {
    }

    public TimeControl(Integer admitApplyTeacher, Integer stipendTeacher, Integer encouragementTeacher, Integer scholarshipTeacher, Integer discountFeeTeacher, Integer admitApplySt, Integer questionarySt, Integer stipendSt, Integer encouragementSt, Integer scholarshipSt, Integer discountFeeSt) {
        this.admitApplyTeacher = admitApplyTeacher;
        this.stipendTeacher = stipendTeacher;
        this.encouragementTeacher = encouragementTeacher;
        this.scholarshipTeacher = scholarshipTeacher;
        this.discountFeeTeacher = discountFeeTeacher;
        this.admitApplySt = admitApplySt;
        this.questionarySt = questionarySt;
        this.stipendSt = stipendSt;
        this.encouragementSt = encouragementSt;
        this.scholarshipSt = scholarshipSt;
        this.discountFeeSt = discountFeeSt;
    }

    public Integer getAdmitApplyTeacher() {
        return admitApplyTeacher;
    }

    public void setAdmitApplyTeacher(Integer admitApplyTeacher) {
        this.admitApplyTeacher = admitApplyTeacher;
    }

    public Integer getStipendTeacher() {
        return stipendTeacher;
    }

    public void setStipendTeacher(Integer stipendTeacher) {
        this.stipendTeacher = stipendTeacher;
    }

    public Integer getEncouragementTeacher() {
        return encouragementTeacher;
    }

    public void setEncouragementTeacher(Integer encouragementTeacher) {
        this.encouragementTeacher = encouragementTeacher;
    }

    public Integer getScholarshipTeacher() {
        return scholarshipTeacher;
    }

    public void setScholarshipTeacher(Integer scholarshipTeacher) {
        this.scholarshipTeacher = scholarshipTeacher;
    }

    public Integer getDiscountFeeTeacher() {
        return discountFeeTeacher;
    }

    public void setDiscountFeeTeacher(Integer discountFeeTeacher) {
        this.discountFeeTeacher = discountFeeTeacher;
    }

    public Integer getAdmitApplySt() {
        return admitApplySt;
    }

    public void setAdmitApplySt(Integer admitApplySt) {
        this.admitApplySt = admitApplySt;
    }

    public Integer getQuestionarySt() {
        return questionarySt;
    }

    public void setQuestionarySt(Integer questionarySt) {
        this.questionarySt = questionarySt;
    }

    public Integer getStipendSt() {
        return stipendSt;
    }

    public void setStipendSt(Integer stipendSt) {
        this.stipendSt = stipendSt;
    }

    public Integer getEncouragementSt() {
        return encouragementSt;
    }

    public void setEncouragementSt(Integer encouragementSt) {
        this.encouragementSt = encouragementSt;
    }

    public Integer getScholarshipSt() {
        return scholarshipSt;
    }

    public void setScholarshipSt(Integer scholarshipSt) {
        this.scholarshipSt = scholarshipSt;
    }

    public Integer getDiscountFeeSt() {
        return discountFeeSt;
    }

    public void setDiscountFeeSt(Integer discountFeeSt) {
        this.discountFeeSt = discountFeeSt;
    }
}
