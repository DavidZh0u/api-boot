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

import com.github.hengboy.api.boot.framework.security.properties.ApiBootSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * api 安全认证自动化配置类
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-11 14:01
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApiBootWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 注入ApiBoot安全属性
     */
    @Autowired
    private ApiBootSecurityProperties apiBootSecurityProperties;

    /**
     * 密码加密方式
     * 自定义加密方式
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置自定义权限管理对象实例
     * 配置后则会采用configure(AuthenticationManagerBuilder auth)方法内的方式进行用户的授权与比对
     * 如果不采用权限管理者方式则使用默认的内部方式，用户名user，密码随机uuid
     *
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean()
            throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 排除安全拦截swagger、actuator等路径
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        List<String> ignoringUrls = new ArrayList<>();
        // 默认排除路径
        ignoringUrls.addAll(Arrays.asList(ApiBootSecurityProperties.DEFAULT_IGNORE_URLS));
        // 自定义排除的路径
        if (!ObjectUtils.isEmpty(apiBootSecurityProperties.getIgnoringUrls())) {
            ignoringUrls.addAll(Arrays.asList(apiBootSecurityProperties.getIgnoringUrls()));
        }
        WebSecurity.IgnoredRequestConfigurer ignoredRequestConfigurer = web.ignoring();
        ignoringUrls.stream().forEach(url -> ignoredRequestConfigurer.antMatchers(url));
    }

    /**
     * 为访问swagger需要禁用http basic
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
    }
}
