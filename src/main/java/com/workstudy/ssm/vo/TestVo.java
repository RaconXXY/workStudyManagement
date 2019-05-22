package com.workstudy.ssm.vo;

//将Excel每一行数值转换为对象
public class TestVo extends InfoVo {
    public static int lastRow = 4;
    private String code;
    private String name;
    private String date;
    private String money;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public TestVo() {
        super(4);
    }

    @Override
    public String getDataField(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return code;
            case 1:
                return name;
            case 2:
                return date;
            case 3:
                return money;
            default:
                return "";
        }
    }
}