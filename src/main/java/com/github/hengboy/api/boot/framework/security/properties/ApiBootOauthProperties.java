package com.github.hengboy.api.boot.framework.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-11 17:33
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "api.boot.oauth")
public class ApiBootOauthProperties {
    /**
     * Oauth2 clientId
     */
    private String clientId = "ApiBoot";
    /**
     * Oauth2 clientSecret
     */
    private String clientSecret = "ApiBootSecret";
    /**
     * 客户端授权类型集合
     */
    private String[] grantTypes = new String[]{"password"};
    /**
     * 客户端作用域集合
     */
    private String[] scopes = new String[]{"api"};
}
