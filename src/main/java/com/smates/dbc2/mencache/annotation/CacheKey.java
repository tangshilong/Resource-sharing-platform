package com.smates.dbc2.mencache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiechanglei
 *         Description : 用以生成配置Memcached时�?数据存放的Key,，当方法的参数中含有多个此注解的时�?，根据value 顺序组装Key
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheKey {
    /**
     * 参数Key的索引，决定了多个参数的组装顺序
     */
    public int value() default 0;
}
