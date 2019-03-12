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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

import static com.github.hengboy.api.boot.framework.security.properties.ApiBootSecurityProperties.API_BOOT_SECURITY_PREFIX;

/**
 * Jdbc方式WebSecurity相关配置
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-12 09:32
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Configuration
@ConditionalOnProperty(prefix = API_BOOT_SECURITY_PREFIX, name = "away", havingValue = SecurityAway.JDBC)
@Import(ApiBootWebSecurityConfiguration.class)
public class ApiBootWebSecurityJdbcConfiguration {
    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(ApiBootWebSecurityJdbcConfiguration.class);
    /**
     * 密码加密方式
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 安全认证管理构建对象
     * 配置指定内存、数据源方式用户认证以及密码加密方式
     */
    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    /**
     * 注入根据用户名查询用户的业务实例
     */
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 配置使用UserDetailsService作为查询用户数据的实现
     * 配置使用ApiSecurityAutoConfiguration@passwordEncoder作为密码校验方式
     */
    @PostConstruct
    public void configure() {
        try {
            authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        } catch (Exception e) {
            logger.error("Exceptions for users configuring jdbc mode", e);
        }
    }
}
