<#if (packageName)??>
package ${packageName};
</#if>
import com.gitee.hengboy.mybatis.enhance.dsl.expression.ColumnExpression;
import com.gitee.hengboy.mybatis.enhance.dsl.expression.TableExpression;
import com.github.hengboy.api.boot.logic.common.entity.${table.entityName}Entity;

/**
  * Created with Code-Builder.
  * 表名: ${table.tableName} - ${table.remark} - 动态查询接口
  *
  * @author：恒宇少年 - 于起宇
  * <p>
  * DateTime：${.now}
  * Blog：http://blog.yuqiyu.com
  * WebSite：http://www.jianshu.com/u/092df3f77bca
  * Gitee：https://gitee.com/hengboy
  * GitHub：https://github.com/hengboy
  */
public class ${className} extends TableExpression<${table.entityName}Entity> {
    public ${className}(String root) {
        super(root);
    }
    public static final ${className} DSL(){return new ${className}("${table.tableName}");}
    <#list table.columns as column>
    public ColumnExpression ${column.javaProperty} = new ColumnExpression("${column.columnName}",this);
    </#list>
    @Override
    public ColumnExpression[] getColumns() {
        return new ColumnExpression[]{
        <#list table.columns as column>
            ${column.javaProperty}
            <#if column_has_next>,</#if>
        </#list>
        };
    }
}
