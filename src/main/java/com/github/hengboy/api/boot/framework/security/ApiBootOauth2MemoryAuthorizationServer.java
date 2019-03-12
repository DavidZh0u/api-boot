package com.github.hengboy.api.boot.framework.security;

import com.github.hengboy.api.boot.framework.security.properties.ApiBootOauthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.annotation.PostConstruct;

import static com.github.hengboy.api.boot.framework.security.properties.ApiBootOauthProperties.API_BOOT_OAUTH_PREFIX;

/**
 * ApiBoot 授权服务器内存方式实现
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-12 13:41
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Configuration
@Import(ApiBootOauth2AuthorizationServer.class)
@ConditionalOnProperty(prefix = API_BOOT_OAUTH_PREFIX, name = "away", havingValue = SecurityAway.MEMORY, matchIfMissing = true)
public class ApiBootOauth2MemoryAuthorizationServer {
    /**
     * 注入客户端详情配置
     */
    @Autowired
    private ClientDetailsServiceConfigurer clientDetailsServiceConfigurer;

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

    /**
     * 配置内存方式Oauth2的客户端信息
     *
     * @throws Exception
     */
    @PostConstruct
    public void configure() throws Exception {
        clientDetailsServiceConfigurer.inMemory()
                .withClient(apiBootOauthProperties.getClientId())
                .secret(passwordEncoder.encode(apiBootOauthProperties.getClientSecret()))
                .authorizedGrantTypes(apiBootOauthProperties.getGrantTypes())
                .scopes(apiBootOauthProperties.getScopes());
    }

    /**
     * 令牌存储方式（内存方式）
     *
     * @return
     */
    @Bean
    TokenStore memoryTokenStore() {
        return new InMemoryTokenStore();
    }
}
