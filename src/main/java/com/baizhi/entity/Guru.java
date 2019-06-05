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
public class Guru implements Serializable {//上师表
    private String id;//id
    private String guRuName;//上师名称
    private String picturePath;//图片路径
    private String status;//状态
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;//创建日期

}
