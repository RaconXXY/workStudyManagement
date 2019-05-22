package com.workstudy.ssm.model;

import java.util.List;

/**
 * Created by Alander on 2017/8/2.
 */
//家庭情况调查表
public class Questionary {
    private String studentId;
    private String tableYear;               //学年字段 YYYY-YYYY格式
    private String sex;                     //"男","女"
    private String birthYear;
    private String birthMonth;
    private String nation;
    private Integer residence;              //入学前户口 0为城镇 1为农村
    private Integer isOrphan;               //是否孤儿 0为否 1为是
    private Integer isDeformity;            //是否残疾
    private Integer isSingleFamily;         //是否单亲
    private Integer isMartyr;               //是否烈士或优抚对象子女
    private Integer isDiffFamily;           //是否农村贫困户或城市低保户
    private String phone;
    private String identityCardId;          //身份证
    private String address;
    private Integer salaryPerYear;          //家庭成员年工资合计
    private Integer indiOperPerYear;        //个体经营总收入
    private Integer assetsIncome;            //资产年收入
    private Integer agricultureIncome;      //农业年净收入
    private Integer sidelineIncome;         //副业年净收入
    private Integer otherIncome;            //其他收入
    private Integer peopleNumber;           //家庭人口
    private Integer totalIncomePerYear;     //家庭年收入总计
    private Integer yearIncomePerPerson;    //家庭人均年收入
    private Integer workPeople;             //家庭劳动力
    private Integer illnessFee;             //家庭成员大病支出
    private Integer tuition;                //非义务制教育输出学费
    private Integer accommodation;          //住宿费
    private Integer naturalLoss;            //自然灾害损失
    private String other;                   //其他说明
    private List<FamilyMember> familyMember;

    public Questionary(String studentId, String tableYear, String sex, String birthYear, String birthMonth, String nation, Integer residence, Integer isOrphan, Integer isDeformity, Integer isSingleFamily, Integer isMartyr, Integer isDiffFamily, String phone, String identityCardId, String address, Integer salaryPerYear, Integer indiOperPerYear, Integer assetsIncome, Integer agricultureIncome, Integer sidelineIncome, Integer otherIncome, Integer peopleNumber, Integer totalIncomePerYear, Integer yearIncomePerPerson, Integer workPeople, Integer illnessFee, Integer tuition, Integer accommodation, Integer naturalLoss, String other, List<FamilyMember> familyMember) {
        this.studentId = studentId;
        this.tableYear = tableYear;
        this.sex = sex;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.nation = nation;
        this.residence = residence;
        this.isOrphan = isOrphan;
        this.isDeformity = isDeformity;
        this.isSingleFamily = isSingleFamily;
        this.isMartyr = isMartyr;
        this.isDiffFamily = isDiffFamily;
        this.phone = phone;
        this.identityCardId = identityCardId;
        this.address = address;
        this.salaryPerYear = salaryPerYear;
        this.indiOperPerYear = indiOperPerYear;
        this.assetsIncome = assetsIncome;
        this.agricultureIncome = agricultureIncome;
        this.sidelineIncome = sidelineIncome;
        this.otherIncome = otherIncome;
        this.peopleNumber = peopleNumber;
        this.totalIncomePerYear = totalIncomePerYear;
        this.yearIncomePerPerson = yearIncomePerPerson;
        this.workPeople = workPeople;
        this.illnessFee = illnessFee;
        this.tuition = tuition;
        this.accommodation = accommodation;
        this.naturalLoss = naturalLoss;
        this.other = other;
        this.familyMember = familyMember;
    }

    public Questionary() {
    }


    public List<FamilyMember> getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(List<FamilyMember> familyMember) {
        this.familyMember = familyMember;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getAssetsIncome() {
        return assetsIncome;
    }

    public void setAssetsIncome(Integer assetsIncome) {
        this.assetsIncome = assetsIncome;
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

    public Integer getResidence() {
        return residence;
    }

    public void setResidence(Integer residence) {
        this.residence = residence;
    }

    public Integer getIsOrphan() {
        return isOrphan;
    }

    public void setIsOrphan(Integer isOrphan) {
        this.isOrphan = isOrphan;
    }

    public Integer getIsDeformity() {
        return isDeformity;
    }

    public void setIsDeformity(Integer isDeformity) {
        this.isDeformity = isDeformity;
    }

    public Integer getIsSingleFamily() {
        return isSingleFamily;
    }

    public void setIsSingleFamily(Integer isSingleFamily) {
        this.isSingleFamily = isSingleFamily;
    }

    public Integer getIsMartyr() {
        return isMartyr;
    }

    public void setIsMartyr(Integer isMartyr) {
        this.isMartyr = isMartyr;
    }

    public Integer getIsDiffFamily() {
        return isDiffFamily;
    }

    public void setIsDiffFamily(Integer isDiffFamily) {
        this.isDiffFamily = isDiffFamily;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getSalaryPerYear() {
        return salaryPerYear;
    }

    public void setSalaryPerYear(Integer salaryPerYear) {
        this.salaryPerYear = salaryPerYear;
    }

    public Integer getIndiOperPerYear() {
        return indiOperPerYear;
    }

    public void setIndiOperPerYear(Integer indiOperPerYear) {
        this.indiOperPerYear = indiOperPerYear;
    }

    public Integer getAgricultureIncome() {
        return agricultureIncome;
    }

    public void setAgricultureIncome(Integer agricultureIncome) {
        this.agricultureIncome = agricultureIncome;
    }

    public Integer getSidelineIncome() {
        return sidelineIncome;
    }

    public void setSidelineIncome(Integer sidelineIncome) {
        this.sidelineIncome = sidelineIncome;
    }

    public Integer getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(Integer otherIncome) {
        this.otherIncome = otherIncome;
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Integer getTotalIncomePerYear() {
        return totalIncomePerYear;
    }

    public void setTotalIncomePerYear(Integer totalIncomePerYear) {
        this.totalIncomePerYear = totalIncomePerYear;
    }

    public Integer getYearIncomePerPerson() {
        return yearIncomePerPerson;
    }

    public void setYearIncomePerPerson(Integer yearIncomePerPerson) {
        this.yearIncomePerPerson = yearIncomePerPerson;
    }

    public Integer getWorkPeople() {
        return workPeople;
    }

    public void setWorkPeople(Integer workPeople) {
        this.workPeople = workPeople;
    }

    public Integer getIllnessFee() {
        return illnessFee;
    }

    public void setIllnessFee(Integer illnessFee) {
        this.illnessFee = illnessFee;
    }

    public Integer getTuition() {
        return tuition;
    }

    public void setTuition(Integer tuition) {
        this.tuition = tuition;
    }

    public Integer getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Integer accommodation) {
        this.accommodation = accommodation;
    }

    public Integer getNaturalLoss() {
        return naturalLoss;
    }

    public void setNaturalLoss(Integer naturalLoss) {
        this.naturalLoss = naturalLoss;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
