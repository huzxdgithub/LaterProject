package com.baizhi.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
public class MyBatisCache implements Cache {
    private String id;

    public MyBatisCache(String id) {
        this.id=id;
    }
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        StringRedisTemplate stringRedisTemplate =(StringRedisTemplate) ApplicationUtils.getclazz(StringRedisTemplate.class);
        System.out.println(stringRedisTemplate);
        System.out.println("放入缓存=================");
        System.out.println(key);
        System.out.println(value);
        String serialize = SerializeUtils.serialize(value);
        stringRedisTemplate.opsForHash().put(id.toString(),key.toString(),serialize);


    }

    @Override
    public Object getObject(Object key) {
        System.out.println("获取缓存");
        StringRedisTemplate stringRedisTemplate =(StringRedisTemplate) ApplicationUtils.getclazz(StringRedisTemplate.class);
        Object o = stringRedisTemplate.opsForHash().get(id.toString(), key.toString());
        if(stringRedisTemplate.opsForHash().hasKey(id.toString(),key.toString())){
            Object o2 = SerializeUtils.serializeToObject((String) stringRedisTemplate.opsForHash().get(id.toString(), key.toString()));
            return o2;
        }
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {
        System.out.println("清空缓存");
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) ApplicationUtils.getclazz(StringRedisTemplate.class);
        System.out.println(id.toString());
        stringRedisTemplate.delete(id.toString());
    }
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
