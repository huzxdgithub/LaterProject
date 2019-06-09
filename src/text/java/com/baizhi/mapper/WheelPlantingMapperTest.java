package com.baizhi.mapper;

import com.baizhi.LaterProjectEntrance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
@SpringBootTest(classes = LaterProjectEntrance.class)
@RunWith(SpringRunner.class)
public class WheelPlantingMapperTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void text(){
        stringRedisTemplate.opsForZSet().add("score", "里斯", 20);
        stringRedisTemplate.opsForZSet().add("score", "王五", 80);
        Set score = stringRedisTemplate.opsForZSet().range("score", 0, -1);
        stringRedisTemplate.opsForZSet().incrementScore("score", "张三", 20);
        Double score1 = stringRedisTemplate.opsForZSet().score("score", "张三");
        System.out.println(score);
        System.out.println(score1);
    }

}