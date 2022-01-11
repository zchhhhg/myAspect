package com.example.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhoucheng
 * @description 必须实现InvocationHandler接口完成代理类要做的功能
 *              调用目标方法，功能增强
 * @date 2022-01-10-17:27
 */
public class MySellHander implements InvocationHandler {

    private Object object = null;

    // 目标对象target是活动的，外界传入的object是什么就创建什么的动态代理
    public MySellHander(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;
        res = method.invoke(object, args);
        if(res != null){
            float price = (float)res + 5;
             res = price;
        }
        return res;
    }
}
