package com.github.hengboy.api.boot.framework.security.jdbc;
import com.gitee.hengboy.mybatis.enhance.dsl.expression.ColumnExpression;
import com.gitee.hengboy.mybatis.enhance.dsl.expression.TableExpression;

/**
  * Created with Code-Builder.
  * 表名: api_boot_user_info - ApiBoot默认的用户信息表 - 动态查询接口
  *
  * @author：恒宇少年 - 于起宇
  * <p>
  * DateTime：Mar 12, 2019 11:44:15 AM
  * Blog：http://blog.yuqiyu.com
  * WebSite：http://www.jianshu.com/u/092df3f77bca
  * Gitee：https://gitee.com/hengboy
  * GitHub：https://github.com/hengboy
  */
public class DApiBootDefaultUserEntity extends TableExpression<ApiBootDefaultUserEntity> {
    public DApiBootDefaultUserEntity(String root) {
        super(root);
    }
    public static final DApiBootDefaultUserEntity DSL(){return new DApiBootDefaultUserEntity("api_boot_user_info");}
    public ColumnExpression uiId = new ColumnExpression("UI_ID",this);
    public ColumnExpression uiUserName = new ColumnExpression("UI_USER_NAME",this);
    public ColumnExpression uiNickName = new ColumnExpression("UI_NICK_NAME",this);
    public ColumnExpression uiPassword = new ColumnExpression("UI_PASSWORD",this);
    public ColumnExpression uiEmail = new ColumnExpression("UI_EMAIL",this);
    public ColumnExpression uiAge = new ColumnExpression("UI_AGE",this);
    public ColumnExpression uiAddress = new ColumnExpression("UI_ADDRESS",this);
    public ColumnExpression uiIsLocked = new ColumnExpression("UI_IS_LOCKED",this);
    public ColumnExpression uiIsEnabled = new ColumnExpression("UI_IS_ENABLED",this);
    public ColumnExpression uiStatus = new ColumnExpression("UI_STATUS",this);
    public ColumnExpression uiCreateTime = new ColumnExpression("UI_CREATE_TIME",this);
    @Override
    public ColumnExpression[] getColumns() {
        return new ColumnExpression[]{
            uiId
            ,
            uiUserName
            ,
            uiNickName
            ,
            uiPassword
            ,
            uiEmail
            ,
            uiAge
            ,
            uiAddress
            ,
            uiIsLocked
            ,
            uiIsEnabled
            ,
            uiStatus
            ,
            uiCreateTime

        };
    }
}
