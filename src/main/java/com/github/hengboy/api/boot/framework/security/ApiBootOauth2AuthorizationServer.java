package com.github.hengboy.api.boot.framework.security;

import com.github.hengboy.api.boot.framework.security.properties.ApiBootOauthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import static com.github.hengboy.api.boot.framework.security.properties.ApiBootOauthProperties.API_BOOT_OAUTH_PREFIX;

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
     * 注入属性配置
     */
    @Autowired
    private ApiBootOauthProperties apiBootOauthProperties;
    /**
     * accessToken存储方式
     * 默认内存方式
     * @see ApiBootOauth2MemoryAuthorizationServer
     * @see ApiBootOauth2JdbcAuthorizationServer
     */
    @Autowired
    private TokenStore tokenStore;

    /**
     * 配置整合SpringSecurity后需要开放OAuth2内部的访问地址
     * 默认开放：/oauth/token
     * 如果你需要开放其他的如：/oauth/check_token、/oauth/token_key等地址
     * 需要在该方法配置权限过滤或者直接去SpringSecurity配置HttpSecurity地址过滤
     *
     * @param oauthServer oauth服务安全配置
     * @throws Exception
     */
    @Override
    public void configure(
            AuthorizationServerSecurityConfigurer oauthServer)
            throws Exception {
        oauthServer
                // 配置开放/oauth/token_key访问地址
                .tokenKeyAccess("permitAll()")
                // 配置开放/oauth/check_token访问地址
                // 必须登录有权限后才可以访问
                .checkTokenAccess("isAuthenticated()");
    }

    /**
     * 配置jwt生成token的转换
     * 使用自定义Sign Key 进行加密
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = API_BOOT_OAUTH_PREFIX, name = "jwt.enable", havingValue = "true")
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(apiBootOauthProperties.getJwt().getSignKey());
        return converter;
    }

    /**
     * 配置授权服务端点
     *
     * @param endpoints 授权服务端点
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // 配置SpringSecurity安全管理对象
                .authenticationManager(authenticationManager)
                // 配置令牌存储方式
                .tokenStore(tokenStore);

        // 开启Jwt，进行配置accessToken的转换
        if (apiBootOauthProperties.getJwt().isEnable()) {
            endpoints.accessTokenConverter(jwtAccessTokenConverter());
        }
    }
}
