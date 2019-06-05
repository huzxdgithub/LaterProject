package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public class Count implements Serializable {//中间表 一个用户可以多个课程  一个课程可以对应多个用户
    private Integer id;//id
    private String title;//标题
    private Integer count;//当前功课的完成情况 念了多少次
    private Integer userId;//用户ID
    private Integer taskId;//功课ID

}
