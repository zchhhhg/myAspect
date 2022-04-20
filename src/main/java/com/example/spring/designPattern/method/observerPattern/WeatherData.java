package com.example.spring.designPattern.method.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-19-10:21
 */
public class WeatherData implements Subject{
    private int temperature;
    private List<Observer> conditions;

    public WeatherData() {
        conditions = new ArrayList<Observer>();
    }

    public int getTemperature() {
        return temperature;
    }

    public void setData(int temperature){
        this.temperature = temperature;
    }

    @Override
    public void registerObserver(Observer observer) {
        conditions.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        conditions.remove(observer);
    }

    @Override
    public void notifybserver() {
        for (int i = 0; i < conditions.size(); i++) {
            conditions.get(i).update(this.temperature);
        }
    }
}
