package com.example.shirospringboot.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @program: shiroDemo1
 * @author: zhangyueli
 * @date: 2020-11-03
 */
@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean:3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
            anon: 无需认证就可以访问
            authc：必须认证了才能访问
            user：必须拥有记住我才能用
            perms：拥有对某个资源的权限才能访问
            role：拥有某个角色权限才能访问
         */
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");

        bean.setFilterChainDefinitionMap(filterMap);

        bean.setLoginUrl("/toLogin");
        return bean;
    }

    //DefaultSecurityManager:2
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserReaml userReaml){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userReaml);
        return securityManager;
    }

    //创建realm对象，需要自定义类:1
    @Bean(name="userRealm")
    public UserReaml userReaml(){
        return new UserReaml();
    }
}
