package com.baizhi.service;

import com.baizhi.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    //分页展示文章
    Map<String,Object>queryPaging(Integer page,Integer rows);
    //添加文章
    Map<String ,Object>addArticle(Article article);
    //修改文章
    Map<String ,Object>updateArticle(Article article);
    //删除文章
    void removeArticle(String[] id);
    //下拉框
    StringBuilder select();
    //查询单个文章
    Article selectOneArticle(String id);

    //查询索引库 多字段查询
    List<Article> searchTitleAndContent(String term);
}
