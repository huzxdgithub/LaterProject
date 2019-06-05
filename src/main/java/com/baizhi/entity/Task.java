package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Accessors
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {//功课表
    private Integer id;//id
    private String title;//标题
    private String taskName;//功课名称
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;//创建日期
    private Integer userId;//用户ID
}
