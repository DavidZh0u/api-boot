package com.github.hengboy.api.boot.framework.security;

import com.github.hengboy.api.boot.framework.security.properties.ApiBootSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * ApiBoot 接口资源服务器配置
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-11 15:19
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Configuration
@EnableResourceServer
public class ApiBootOauth2ResourceServer extends ResourceServerConfigurerAdapter {
    /**
     * 注入属性配置
     */
    @Autowired
    private ApiBootSecurityProperties apiBootSecurityProperties;

    /**
     * 配置开启对指定前缀路径的认证
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .requestMatchers()
                .antMatchers(apiBootSecurityProperties.getAuthPrefix());
    }

}
