package com.github.hengboy.api.boot.framework.security.jdbc;
import com.gitee.hengboy.mybatis.enhance.common.annotation.Column;
import com.gitee.hengboy.mybatis.enhance.common.annotation.Id;
import com.gitee.hengboy.mybatis.enhance.common.annotation.Table;
import com.gitee.hengboy.mybatis.enhance.common.enums.KeyGeneratorTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
  * Created with Code-Builder.
  * 表名: api_boot_user_info - ApiBoot默认的用户信息表 - 数据实体
  *
  * @author：恒宇少年 - 于起宇
  * <p>
  * DateTime：Mar 12, 2019 11:44:15 AM
  * Blog：http://blog.yuqiyu.com
  * WebSite：http://www.jianshu.com/u/092df3f77bca
  * Gitee：https://gitee.com/hengboy
  * GitHub：https://github.com/hengboy
  */
@Data
@Table(name = "api_boot_user_info")
@ApiModel
public class ApiBootDefaultUserEntity {
    /**
     * UI_ID - 用户编号，主键自增
     */
    @Id(generatorType = KeyGeneratorTypeEnum.AUTO)
    @Column(name="UI_ID")
    @ApiModelProperty("用户编号，主键自增")
    private Integer uiId;
    /**
     * UI_USER_NAME - 用户名
     */
    @Column(name="UI_USER_NAME")
    @ApiModelProperty("用户名")
    private String uiUserName;
    /**
     * UI_NICK_NAME - 用户昵称
     */
    @Column(name="UI_NICK_NAME")
    @ApiModelProperty("用户昵称")
    private String uiNickName;
    /**
     * UI_PASSWORD - 用户密码
     */
    @Column(name="UI_PASSWORD")
    @ApiModelProperty("用户密码")
    private String uiPassword;
    /**
     * UI_EMAIL - 用户邮箱地址
     */
    @Column(name="UI_EMAIL")
    @ApiModelProperty("用户邮箱地址")
    private String uiEmail;
    /**
     * UI_AGE - 用户年龄
     */
    @Column(name="UI_AGE")
    @ApiModelProperty("用户年龄")
    private Integer uiAge;
    /**
     * UI_ADDRESS - 用户地址
     */
    @Column(name="UI_ADDRESS")
    @ApiModelProperty("用户地址")
    private String uiAddress;
    /**
     * UI_IS_LOCKED - 是否锁定
     */
    @Column(name="UI_IS_LOCKED",insertable = false)
    @ApiModelProperty("是否锁定")
    private String uiIsLocked;
    /**
     * UI_IS_ENABLED - 是否启用
     */
    @Column(name="UI_IS_ENABLED",insertable = false)
    @ApiModelProperty("是否启用")
    private String uiIsEnabled;
    /**
     * UI_STATUS - O：正常，D：已删除
     */
    @Column(name="UI_STATUS",insertable = false)
    @ApiModelProperty("O：正常，D：已删除")
    private String uiStatus;
    /**
     * UI_CREATE_TIME - 用户创建时间
     */
    @Column(name="UI_CREATE_TIME",insertable = false)
    @ApiModelProperty("用户创建时间")
    private Timestamp uiCreateTime;
}
