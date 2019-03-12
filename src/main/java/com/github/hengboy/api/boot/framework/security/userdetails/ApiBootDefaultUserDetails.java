package com.github.hengboy.api.boot.framework.security.userdetails;

import com.github.hengboy.api.boot.framework.enums.YesOrNo;
import com.github.hengboy.api.boot.framework.security.jdbc.ApiBootDefaultUserEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ApiBoot默认实现SpringSecurity的UserDetails接口逻辑
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-12 10:59
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Data
public class ApiBootDefaultUserDetails extends ApiBootDefaultUserEntity implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList() {
            {
                add((GrantedAuthority) () -> "ROLE_USER");
            }
        };
    }

    @Override
    public String getPassword() {
        return super.getUiPassword();
    }

    @Override
    public String getUsername() {
        return super.getUiUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return YesOrNo.NO.getValue().equals(super.getUiIsLocked());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return YesOrNo.YES.getValue().equals(super.getUiIsEnabled());
    }
}
