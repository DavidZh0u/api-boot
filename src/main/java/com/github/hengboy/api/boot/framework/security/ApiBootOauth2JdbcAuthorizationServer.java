/*
 * Copyright [2019] [恒宇少年 - 于起宇]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.github.hengboy.api.boot.framework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import static com.github.hengboy.api.boot.framework.security.properties.ApiBootOauthProperties.API_BOOT_OAUTH_PREFIX;

/**
 * ApiBoot 授权服务器Jdbc方式实现
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
@ConditionalOnProperty(prefix = API_BOOT_OAUTH_PREFIX, name = "away", havingValue = SecurityAway.JDBC)
public class ApiBootOauth2JdbcAuthorizationServer {
    /**
     * oauth2表所处数据库的数据源
     */
    @Autowired
    private DataSource dataSource;
    /**
     * 密码加密方式
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 注入客户端详情配置
     */
    @Autowired
    private ClientDetailsServiceConfigurer clientDetailsServiceConfigurer;

    /**
     * 配置Jdbc方式Oauth2的客户端信息
     *
     * @throws Exception
     */
    @PostConstruct
    public void configure() throws Exception {
        clientDetailsServiceConfigurer
                // 配置数据源
                .jdbc(dataSource)
                // 配置密码加密方式
                .passwordEncoder(passwordEncoder);
    }

    /**
     * 令牌存储方式（数据库方式）
     *
     * @param dataSource
     * @return
     */
    @Bean
    TokenStore jdbcTokenStore(DataSource dataSource) {
        return new JdbcTokenStore(dataSource);
    }

}
