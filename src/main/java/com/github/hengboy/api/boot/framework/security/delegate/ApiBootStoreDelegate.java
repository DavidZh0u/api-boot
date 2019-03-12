package com.github.hengboy.api.boot.framework.security.delegate;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * ApiBoot的数据存储委托接口
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-12 10:46
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
public interface ApiBootStoreDelegate {
    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户对象信息
     * @throws UsernameNotFoundException 用户不存的异常跑出
     */
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
