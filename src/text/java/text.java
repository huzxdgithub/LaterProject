import com.baizhi.LaterProjectEntrance;
import com.baizhi.entity.Article;
import com.baizhi.es.UserRepository;
import com.baizhi.es.dao.ArticleDAO;
import com.baizhi.mapper.UserMapper;
import com.baizhi.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = LaterProjectEntrance.class)
@RunWith(SpringRunner.class)
public class text {

    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleDAO articleDAO ;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;
    @Test
    public void text(){
        List<Article> list = articleDAO.searchTileAndContent("小黑");
        for (Article article : list) {
            System.out.println(article);
        }
    }
    @Test
    public void  mani() {
        Article article = new Article();
        article.setId("3").setStatus("1").setContent("ElasticSearch是一款由小黑开发的安全认证权限框架").setTitle("小三").setGuRuId("1").setCreateDate(new Date()).setAuthor("吴承恩");
        Article save = userRepository.save(article);
    }

}

