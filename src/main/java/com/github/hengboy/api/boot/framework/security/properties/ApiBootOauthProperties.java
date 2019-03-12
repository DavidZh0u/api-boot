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
package com.github.hengboy.api.boot.framework.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static com.github.hengboy.api.boot.framework.security.properties.ApiBootOauthProperties.API_BOOT_OAUTH_PREFIX;

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
@ConfigurationProperties(prefix = API_BOOT_OAUTH_PREFIX)
public class ApiBootOauthProperties {
    /**
     * 安全配置前缀
     */
    public static final String API_BOOT_OAUTH_PREFIX = "api.boot.oauth";
    /**
     * Oauth2认证存储方式
     * @see com.github.hengboy.api.boot.framework.security.SecurityAway
     */
    private String away;
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
    /**
     * 配置JWT格式化Oauth2返回的token
     */
    private Jwt jwt = new Jwt();

    /**
     * 自定义Jwt相关的配置
     */
    @Data
    public class Jwt {
        private boolean enable = false;
        private String signKey = "ApiBoot";
    }
}
