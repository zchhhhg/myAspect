package com.example.spring.designPattern.method.observerPattern;

import java.util.Date;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-20-8:54
 */
public class HuaweiObserver extends Observer {
    @Override
    public void update(int temperature) {
        System.out.println(new Date().toString() + "华为天气获取到当前温度：" + temperature);
    }
}
