package com.workstudy.ssm.model;

/**
 * Created by Alander on 2017/7/30.
 */
public class User {
    private String userId;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String academy;
    private String major;
    private String className;
    private int type; //0:student,1:teacher,2:manager

    public User() {
    }

    public User(String userId, String password, String email, String phone, String academy, String major, String className, int type) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.academy = academy;
        this.major = major;
        this.className = className;
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "userId:" + userId + "; password:" + password + "; type" + type + ";";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if ((obj == null) || !(obj instanceof User))
            return false;
        User user = (User) obj;

        //这三个字段相等就可以认为他们一样了(事实上第一个就够了但是登录有三个字段)
        boolean userId = this.userId.equals(user.userId);
        boolean password = this.password.equals(user.password);
        boolean type = this.type == user.type;
        return userId && password && type;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        //同上 就判断三个字段
        hash = 31 * hash + type;
        hash = 31 * hash + (null == userId ? 0 : userId.hashCode());
        hash = 31 * hash + (null == password ? 0 : password.hashCode());
        return hash;
    }


}
