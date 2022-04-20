package com.example.spring.designPattern.method.observerPattern;

import java.util.Date;

/**
 * @author zhoucheng
 * @description 百度天气接入方
 * @date 2022-04-19-10:16
 */
public class BaiduObserver extends Observer {
    @Override
    public void update(int temperature) {
        System.out.println(new Date().toString() + "百度天气获取到当前温度：" + temperature);
    }
}
