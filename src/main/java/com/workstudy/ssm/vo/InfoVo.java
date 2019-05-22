package com.workstudy.ssm.vo;

//抽象基类，提供excel对应单元格内容的抽象
//将Excel每一行数值转换为对象
//主要为了导出excel工具的良好封装
public abstract class InfoVo {

    //excel有数据的最后一行，就是要填第一行的上面一行
    public static int lastRow;

    //字段数量
    private int fieldLenth;

    //子类默认构造函数要初始化fieldLenth字段
    InfoVo(int fieldLenth){
        this.fieldLenth = fieldLenth;
    }

    public int getFieldLenth() {
        return fieldLenth;
    }

    /**
     * 根据每一列的数据内容提供迭代（switch case default）
     * @param columnIndex 迭代的列的下标（对应excel）
     * @return 填充入excel对应下标的值
     */
    public abstract String getDataField(int columnIndex);
}