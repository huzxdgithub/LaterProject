package com.baizhi.serviceimpl;

import com.baizhi.aopcache.AddCache;
import com.baizhi.aopcache.DelCache;
import com.baizhi.entity.Article;
import com.baizhi.entity.Guru;
import com.baizhi.mapper.ArticleMapper;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    @AddCache
    //查询所有文章 jqGrid展示
    public Map<String, Object> queryPaging(Integer page, Integer rows) {
        Map<String, Object> map = new ConcurrentHashMap<String,Object>();
        //放入当前页
        map.put("page",page);
        //放入总条数
        Integer totalCount= articleMapper.selectCount();
        map.put("records",totalCount);
        //放入最大页
        if(totalCount%rows!=0){
            map.put("total",totalCount/rows+1);
        }else {
            map.put("total",totalCount/rows);
        }
        //放入数据
        List<Article> articles = articleMapper.queryPaging(page, rows);
        for (Article article : articles) {
            //根据上师ID查询出来一个上师获取上师名称赋值给文章中的作者
            article.setAuthor(articleMapper.currentGuru(article.getGuRuId()).getGuRuName());
            map.put("rows",articles);
        }
        return map;
    }
    //添加文章
    @Override
    @DelCache
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> addArticle(Article article) {
        article.setCreateDate(new Date());
        article.setId(UUID.randomUUID().toString());
        articleMapper.addArticle(article);
        return null;
    }
    //修改文章
    @Override
    @DelCache
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> updateArticle(Article article) {
        if("".equals(article.getContent())){
            article.setContent(null);
        }
        articleMapper.updateArticle(article);
        return null;
    }
    //删除文章
    @DelCache
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeArticle(String[] id) {
        articleMapper.removeArticle(id);

    }
    //下拉框
    @AddCache
    @Override
    public StringBuilder select() {
        List<Guru> gurus = articleMapper.queryGuRuAll();
        StringBuilder sb = new StringBuilder();
        sb.append("<select id='select' name='guRuId' class='form-control'>");
        for (Guru guru : gurus) {
           sb.append("<option value="+guru.getId()+">"+guru.getGuRuName()+"</option>");
        }
        sb.append("</select>");
        return sb;
    }
    //查询单个文章
    @Transactional(propagation = Propagation.SUPPORTS)
    @AddCache
    @Override
    public Article selectOneArticle(String id) {
         return   articleMapper.selectOneArticle(id);
    }


}
