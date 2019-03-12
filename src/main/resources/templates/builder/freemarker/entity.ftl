<#if (packageName)??>
package ${packageName};
</#if>
<#if (table.hasSqlDate)>
import java.sql.Date;
</#if>
<#if (table.hasTimeStamp)>
import java.sql.Timestamp;
</#if>
<#if (table.hasBigDecimal)>
import java.math.BigDecimal;
</#if>
import com.gitee.hengboy.mybatis.enhance.common.annotation.Column;
import com.gitee.hengboy.mybatis.enhance.common.annotation.Id;
import com.gitee.hengboy.mybatis.enhance.common.annotation.Table;
import com.gitee.hengboy.mybatis.enhance.common.enums.KeyGeneratorTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
  * Created with Code-Builder.
  * 表名: ${table.tableName} - ${table.remark} - 数据实体
  *
  * @author：恒宇少年 - 于起宇
  * <p>
  * DateTime：${.now}
  * Blog：http://blog.yuqiyu.com
  * WebSite：http://www.jianshu.com/u/092df3f77bca
  * Gitee：https://gitee.com/hengboy
  * GitHub：https://github.com/hengboy
  */
@Data
@Table(name = "${table.tableName}")
@ApiModel
public class ${className} {
<#list table.primaryKeys as key>
    /**
     * ${key.columnName} - ${key.remark}
     */
    <#if (key.autoincrement)>
    @Id(generatorType = KeyGeneratorTypeEnum.AUTO)
    <#else>
    @Id(generatorType = KeyGeneratorTypeEnum.UUID)
    </#if>
    @Column(name="${key.columnName}")
    @ApiModelProperty("${key.remark}")
    private ${key.javaType} ${key.javaProperty};
</#list>
<#list table.columns as column>
    <#if (!column.primaryKey)>
    /**
     * ${column.columnName} - ${column.remark}
     */
    @Column(name="${column.columnName}"<#if (column.defaultValue)??>,insertable = false</#if>)
    @ApiModelProperty("${column.remark}")
    private ${column.javaType} ${column.javaProperty};
    </#if>
</#list>
}
