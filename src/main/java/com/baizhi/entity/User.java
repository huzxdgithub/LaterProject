package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors
public class User implements Serializable {//用户表
    @Excel(name="编号", needMerge=true)
    /*@Excel(name="编号", needMerge=true)      needMerge=true代表合并列多表连接导出的时候用  */
    private Integer id;//id
    @Excel(name="手机号")
    private String phone;//手机号
    @Excel(name="密码")
    private String password;//密码
    @Excel(name="图片",type = 2,width = 40,height = 20)
    private String picturePath;//图片路径
    @Excel(name="法名")
    private String legalName;//法名
    @Excel(name="姓名")
    private String name;//姓名
    @Excel(name="性别")
    private String sex;//性别
    @ExcelIgnore
    private String province;//省份
    @ExcelIgnore
    private String city;//城市
    @ExcelIgnore
    private Integer guRuId;//上师ID
    @Excel(name="状态")
    private String status;//状态
    @Excel(name="创建时间",format = "yyyy-MM-dd")
    private Date createDate;//创建时间
    private String month1;
    private Integer value;
}
