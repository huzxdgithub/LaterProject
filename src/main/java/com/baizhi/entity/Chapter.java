package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors
public class Chapter implements Serializable {//章节表
    private String id;//id
    private String title;//标题
    private String size;//音频大小
    private String duration;//音频时长
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;//创建时间
    private String audioFrequency;//音频所在路径
    private String albumId;//专辑ID
}
