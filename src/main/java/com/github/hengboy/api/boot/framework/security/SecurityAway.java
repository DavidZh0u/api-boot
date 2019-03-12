package com.github.hengboy.api.boot.framework.security;

/**
 * 认证安全方式枚举
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-11 13:57
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
public interface SecurityAway {
    /**
     * 内存方式
     */
    String MEMORY = "memory";
    /**
     * 数据库方式
     */
    String JDBC = "jdbc";
}
