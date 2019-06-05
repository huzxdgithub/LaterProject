import com.baizhi.LaterProjectEntrance;
import com.baizhi.es.UserRepository;
import com.baizhi.es.dao.ArticleDAO;
import com.baizhi.es.entity.User;
import com.baizhi.mapper.UserMapper;
import com.baizhi.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<User> list = articleDAO.userSearch("亮");
        for (User user : list) {
            System.out.println(user.getContent());
        }
    }
    @Test
    public void  mani() {

        final HashMap<Integer, Integer> map = new HashMap<>();
        Thread thread = new Thread() {
            public void run() {
                map.put(1,1);
            }
        };
        thread.start();
        map.put(2,2);

    }

}

