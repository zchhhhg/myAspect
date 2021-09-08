package com.example.spring.aspect;

import java.lang.annotation.*;

/**
 * <br>Date:2019年5月27日
 * @author Cheng
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheRedis {

	String key() default "";
}
