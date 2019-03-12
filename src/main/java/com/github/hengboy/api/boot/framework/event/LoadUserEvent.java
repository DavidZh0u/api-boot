package com.github.hengboy.api.boot.framework.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Jdbc方式查询用户的事件
 * 可以监听该事件获取登录用户的信息
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-12 10:14
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Getter
public class LoadUserEvent extends ApplicationEvent {
    /**
     * 获取用户信息的用户名
     */
    private String username;
    /**
     * 查询到的用户信息
     */
    private UserDetails userDetails;

    public LoadUserEvent(Object source, String username, UserDetails userDetails) {
        super(source);
        this.username = username;
        this.userDetails = userDetails;
    }
}
