package com.baizhi.cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class ApplicationUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    //根据名字获取工厂对象(相当于根据beanid)
    public static Object getNameBean(String bean){

        return   applicationContext.getBean(bean);
    }
    public static Object getclazz(Class clazz){
        return applicationContext.getBean(clazz);
    }

    public static Object getBeanByClassAndName(String name,Class clazz){
        Object bean = applicationContext.getBean(name,clazz);
        return bean;
    }

    public static void main(String[] args) {
        A a=new A();
        a.met();

    }


}

class A{
    public void met(){
        final int a=5;
        A b=new A(){
           public void me(){
               System.out.println(a);
           }
        };

    }
}
