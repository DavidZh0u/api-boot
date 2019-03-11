package com.github.hengboy.api.boot;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Api Boot 入口程序类
 *
 * @EnableSwagger2Doc 该注解用于开启swagger文档
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：2019-03-11 10:18
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@SpringBootApplication
@EnableSwagger2Doc
public class ApiBootApplication {
    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(ApiBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ApiBootApplication.class, args);
        logger.info("Api Boot Start Successfully.");
    }

}
