package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Accessors
@NoArgsConstructor
public class Admin implements Serializable {//管理员表
    private Integer id;
    private String adminName;//管理员名称
    private String adminPassword;//管理员密码
    private String salt;//盐值
}
