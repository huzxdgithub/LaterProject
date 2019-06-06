package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)//该对象的链式调用get  set方法
@Document(indexName = "laterproject", type = "article")//indexName是索引库映射  type是索引库类型
public class Article implements Serializable {//文章表
    @Id
    private String id;//id
    @Field(type = FieldType.Keyword)
    private String title;//标题
    @Field(type = FieldType.Keyword)
    private String status;//状态
    @Field(type = FieldType.Keyword)
    private String author;//作者
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Field(type = FieldType.Date)
    private Date createDate;//创建时间
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;//内容
    @Field(type = FieldType.Keyword)
    private String guRuId;//上师ID
    private Guru guru;
}
