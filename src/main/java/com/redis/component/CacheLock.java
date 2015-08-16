package com.redis.component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

/**
 * 
 * @author zhengwen
 * 缓存锁注解，注意目前只支持锁基本数据类型以及他们的包装类Integer,Long......和String
 * 使用该注解需要在xml里面配置 org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheLock {
    public String lockedPrefix() default "";// redis锁key的前缀。防止key值冲突

    public long timeOut() default 2000;// 锁时间

    public int expireTime() default 3;// key在redis里面存在时间
}
