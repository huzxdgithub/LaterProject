package com.baizhi.aopcache;

import com.baizhi.cache.SerializeUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@Aspect//声明当前类是一个切面 供容器读取
public class AopCache {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Around("@annotation(com.baizhi.aopcache.AddCache)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint)  {
       StringBuilder sb=new StringBuilder();
        //className 就是service的路径把
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //获取名称方法名称 method
        String methodName = proceedingJoinPoint.getSignature().getName();
        sb.append(methodName);
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            sb.append(arg);
        }

        Object result=null;
        if (stringRedisTemplate.opsForHash().get(className, sb.toString()) != null) {
            System.out.println("获取缓存");
            result = stringRedisTemplate.opsForHash().get(className, sb.toString());
            result = SerializeUtils.serializeToObject(result.toString());
        }else {
            try {
                result=proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            String serialize = SerializeUtils.serialize(result);
            stringRedisTemplate.opsForHash().put(className, sb.toString(), serialize);
        }
        return result;
    }
    @After("@annotation(com.baizhi.aopcache.DelCache)")
    public void DelCache(JoinPoint joinPoint){
        String name = joinPoint.getTarget().getClass().getName();
        stringRedisTemplate.delete(name);
        System.out.println("清空缓存");
        System.out.println(name);
    }
}