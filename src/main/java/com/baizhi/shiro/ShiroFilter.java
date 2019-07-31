package com.baizhi.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ShiroFilter {
    //创建 ShiroFilterFactoryBean对象
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
            //添加匿名资源
            Map<String,String> map = new HashMap<>();
            map.put("/backstage/**","anon");
            map.put("/Admin/login","anon");
            map.put("/login/**","anon");
        //放入匿名资源
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //如果访问了非匿名资源并且未认证跳入该页面
        shiroFilterFactoryBean.setLoginUrl("/login/login.jsp");
        //添加SecurityManager  这个是SecurityManager的子类
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        return shiroFilterFactoryBean;
    }
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(MyRealm myRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //添加shiro缓存
        MemoryConstrainedCacheManager memoryConstrainedCacheManager=new MemoryConstrainedCacheManager();
        defaultWebSecurityManager.setCacheManager(memoryConstrainedCacheManager);
        //添加自定义Realm
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }
    @Bean
    public MyRealm getMyRealm(){
        MyRealm myRealm = new MyRealm();
        //添加信息凭证 加密 加散列   加盐  盐在 myRealm里面的认证里面
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("Md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return myRealm;
    }

}
