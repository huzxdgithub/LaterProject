package com.baizhi.mapper;

import com.baizhi.entity.Article;
import com.baizhi.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    //分页展示文章
    List<Article> queryPaging(@Param("page") Integer page ,@Param("rows") Integer rows);
    //查询文章总条数
    Integer selectCount();
    //查询对应的上师
    Guru currentGuru(@Param("id") String id);
    //添加文章
    void addArticle(Article article);
    //修改文章
    void updateArticle(Article article);
    //删除文章
    void removeArticle(String [] id);
    //查询所有未冻结的上师 添加文章时给下拉框 让选择是哪位上师发布的文章
    List<Guru> queryGuRuAll();
    //查询单个文章
    Article selectOneArticle(@Param("id") String id);

}
