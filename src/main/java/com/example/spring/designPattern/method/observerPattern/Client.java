package com.example.spring.designPattern.method.observerPattern;

import java.awt.*;
import java.util.WeakHashMap;

/**
 * @author zhoucheng
 * @description 观察者模式 天气预报推送 奶站送奶
 * @date 2022-04-08-14:33
 */
public class Client {

    public static void main(String[] args) throws AWTException {
        WeatherData weatherData = new WeatherData();
        BaiduObserver observer1 = new BaiduObserver();
        weatherData.registerObserver(observer1);
        weatherData.setData(10);
        HuaweiObserver observer2 = new HuaweiObserver();
        weatherData.registerObserver(observer2);
        weatherData.notifybserver();
    }
}
