<#if (packageName)??>
package ${packageName};
</#if>

import com.gitee.hengboy.mybatis.enhance.mapper.EnhanceMapper;
import com.github.hengboy.api.boot.logic.common.entity.${table.entityName}Entity;
/**
 * Created with Code-Builder.
 * 表名: ${table.tableName} - ${table.remark} - 数据接口
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：${.now}
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
public interface ${className}
     extends EnhanceMapper<${table.entityName}Entity,<#list table.primaryKeys as key><#if key_index == 0> ${key.javaType}</#if></#list>> {

}
