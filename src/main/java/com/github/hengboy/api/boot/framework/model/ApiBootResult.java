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
package com.github.hengboy.api.boot.framework.model;

import lombok.Builder;
import lombok.Data;

/**
 * 接口查询结果实体
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-11 13:18
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Data
@Builder
public class ApiBootResult {
    /**
     * 返回数据
     * 该字段可为集合、基础数据类型、对象实例等
     */
    private Object data;
    /**
     * 接口返回错误码
     * 自定义传递值
     */
    private String errorCode;
    /**
     * 接口返回错误消息内容
     */
    private String errorMessage;
}
