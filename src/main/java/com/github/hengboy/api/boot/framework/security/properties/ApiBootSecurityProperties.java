package com.github.hengboy.api.boot.framework.security.properties;

import com.github.hengboy.api.boot.framework.configure.security.SecurityUser;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.github.hengboy.api.boot.framework.security.properties.ApiBootSecurityProperties.API_BOOT_SECURITY_PREFIX;

/**
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-11 17:30
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Data
@Configuration
@ConfigurationProperties(prefix = API_BOOT_SECURITY_PREFIX)
public class ApiBootSecurityProperties {
    /**
     * 安全配置前缀
     */
    public static final String API_BOOT_SECURITY_PREFIX = "api.boot.security";
    /**
     * 认证接口地址的前缀
     * 默认只拦截/api/**下的接口地址
     */
    private String authPrefix = "/api/**";
    /**
     * 安全认证方式
     * 默认采用内存方式验证
     */
    private String away;
    /**
     * 配置内存方式的用户列表
     * key：用户名
     * value：密码
     */
    private List<SecurityUser> users = new ArrayList<>();
}
