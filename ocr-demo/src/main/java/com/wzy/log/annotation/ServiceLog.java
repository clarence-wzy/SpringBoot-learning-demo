package com.wzy.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Package: com.wzy.log.annotation
 * @Author: Clarence1
 * @Date: 2019/9/17 16:02
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceLog {

    /**
     * 描述业务操作 例：XXX管理-执行XXX操作
     *
     * @return
     */
    String description() default "";

}
