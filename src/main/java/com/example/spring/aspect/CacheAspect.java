package com.example.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Cheng
 * @date 2021-08-30-9:27
 */
@Component
@Aspect
public class CacheAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    @Around("@annotation(cacheRedis)")
    public Object aroundCache(ProceedingJoinPoint point, CacheRedis cacheRedis) throws Throwable {
            String key = cacheRedis.key();
            if(!("".equals(key) || null == key)){
            Object result=redisTemplate.opsForValue().get(key);
            if("".equals(result) || null == result) {
                if(result!=null&& result instanceof List){
                    return result;
                }
                result=point.proceed();
                //加入缓存
                redisTemplate.opsForValue().set(key, result);
                System.out.println("设置缓存key"+key+"value:"+ result);
            }else {
                System.out.println("从缓存中获取数据"+result);
            }
            return result;
        } else {
            return point.proceed();
        }
    }
}
