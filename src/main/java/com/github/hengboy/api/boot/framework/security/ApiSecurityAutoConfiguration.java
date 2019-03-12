package com.github.hengboy.api.boot.framework.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
public class ApiSecurityAutoConfiguration extends WebSecurityConfigurerAdapter {
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
}
