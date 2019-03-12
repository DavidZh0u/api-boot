<#if (packageName)??>
package ${packageName};
</#if>

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created with Code-Builder.
 * 表名: ${table.tableName} - ${table.remark} - 业务逻辑
 *
 * @author：恒宇少年 - 于起宇
 * <p>
 * DateTime：${.now}
 * Blog：http://blog.yuqiyu.com
 * WebSite：http://www.jianshu.com/u/092df3f77bca
 * Gitee：https://gitee.com/hengboy
 * GitHub：https://github.com/hengboy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ${className}{

}
