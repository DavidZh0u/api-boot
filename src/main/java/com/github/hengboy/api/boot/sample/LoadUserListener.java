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
package com.github.hengboy.api.boot.sample;

import com.alibaba.fastjson.JSON;
import com.github.hengboy.api.boot.framework.event.LoadUserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * JDBC方式查询用户事件监听示例
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-12 10:56
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Component
public class LoadUserListener implements SmartApplicationListener {
    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(LoadUserListener.class);

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == LoadUserEvent.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        LoadUserEvent loadUserEvent = (LoadUserEvent) applicationEvent;
        logger.info("登录用户：{}，用户信息：{}", loadUserEvent.getUsername(), JSON.toJSONString(loadUserEvent.getUserDetails()));
    }
}
