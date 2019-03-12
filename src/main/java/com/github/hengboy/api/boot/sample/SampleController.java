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

import com.github.hengboy.api.boot.framework.model.ApiBootResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器示例
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-12 16:02
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@RestController
@RequestMapping(value = "/api/sample")
public class SampleController {
    /**
     * 简单swagger文档示例
     *
     * @param userName 用户名
     * @return
     */
    @GetMapping(value = "/echo")
    @ApiOperation(value = "输出用户名", response = ApiBootResult.class)
    @ApiResponse(code = 200, message = "处理成功", response = ApiBootResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", required = true),
    })
    public ApiBootResult echo(String userName) {
        return ApiBootResult.wrapper()
                .data("Hello：" + userName)
                .build();
    }
}
