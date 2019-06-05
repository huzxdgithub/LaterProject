package com.baizhi.contorller;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/Article")
public class ArticleContorller {
    @Autowired
    ArticleService articleService;
    @RequestMapping("/queryPaging")
    public Map<String , Object>queryPaging(Integer page,Integer rows){
        Map<String, Object> map = articleService.queryPaging(page, rows);
        return map;
    }
    //增删改文章
    @RequestMapping("/edit")
    public Map<String ,Object> addArticle(String oper,String [] id,Article article){
        if(("del").equals(oper)){
            articleService.removeArticle(id);
            return null;
        }
        if(("edit").equals(oper)){
          return   articleService.updateArticle(article);
        }
        return articleService.addArticle(article);
    }
    //查询所有上师 添加文章使用 下拉框返回
    @RequestMapping("/select")
    public void options(HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        StringBuilder sb = articleService.select();
        try {
            PrintWriter writer = response.getWriter();
            writer.print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/selectOneArticle")
    public Article selectOneArticle(String id){
        return articleService.selectOneArticle(id);
    }
}
