package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public class Album implements Serializable {//专辑表
    private String id;//id
    private String title;//标题
    private String score;//评分
    private String author;//作者
    private String broadcast;//广播员
    private Integer count;//章节数量
    private String brief;//内容简介
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;//创建时间
    private String picturePath;//图片路径
}
