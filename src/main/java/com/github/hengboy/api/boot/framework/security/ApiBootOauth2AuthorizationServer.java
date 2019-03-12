package com.github.hengboy.api.boot.framework.security;

import com.github.hengboy.api.boot.framework.security.properties.ApiBootOauthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * ApiBoot授权服务器配置
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-11 15:22
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Configuration
@EnableAuthorizationServer
public class ApiBootOauth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    /**
     * 用户授权认证
     */
    @Autowired
    private AuthenticationManager authenticationManager;
    /**
     * 加密方式
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 注入属性配置
     */
    @Autowired
    private ApiBootOauthProperties apiBootOauthProperties;



    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(apiBootOauthProperties.getClientId())
                .secret(passwordEncoder.encode(apiBootOauthProperties.getClientSecret()))
                .authorizedGrantTypes(apiBootOauthProperties.getGrantTypes())
                .scopes(apiBootOauthProperties.getScopes());
    }
}
