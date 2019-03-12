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
package com.github.hengboy.api.boot.framework.security.delegate.support;

import com.gitee.hengboy.mybatis.enhance.dsl.factory.EnhanceDslFactory;
import com.github.hengboy.api.boot.framework.security.delegate.ApiBootStoreDelegate;
import com.github.hengboy.api.boot.framework.security.jdbc.DApiBootDefaultUserEntity;
import com.github.hengboy.api.boot.framework.security.userdetails.ApiBootDefaultUserDetails;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * ApiBoot提供的默认数据委托实现类
 * 注意：需要遵循ApiBoot的表名、表结构创建用户表
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-12 10:48
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Service
public class ApiBootDefaultStoreDelegate implements ApiBootStoreDelegate {
    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(ApiBootDefaultStoreDelegate.class);
    /**
     * Mybatis-Enhance 动态查询语言工厂对象
     */
    EnhanceDslFactory enhanceDsl;
    /**
     * 注入Mybatis SqlSession
     */
    @Autowired
    private SqlSession sqlSession;

    /**
     * 初始化Mybatis Enhance 查询工厂对象
     */
    @PostConstruct
    public void __initialization() {
        this.enhanceDsl = new EnhanceDslFactory(this.sqlSession);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户对象信息
     * @throws UsernameNotFoundException 用户不存的异常跑出
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 动态查询对象，mybatis-enhance所需对象
        DApiBootDefaultUserEntity dApiBootDefaultUserEntity = DApiBootDefaultUserEntity.DSL();
        // 执行动态查询
        return enhanceDsl.createSearchable().selectFrom(dApiBootDefaultUserEntity).where(dApiBootDefaultUserEntity.uiUserName.eq(username)).resultType(ApiBootDefaultUserDetails.class).fetchOne();
    }
}
