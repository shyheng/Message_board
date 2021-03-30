package com.shy.web.config;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration

public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        /*
         * 无需认证 anon
         * 验证可访问 authc
         * user 必须有记住我才能使用
         * perms 有对某个资源的权限才能访问
         * role 拥有某个角色才能访问
         * */


        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/index","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        bean.setLoginUrl("/user/login");
        bean.setUnauthorizedUrl("/user/login");
        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;

    }

    @Bean("userRealm")
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }
}
