package com.example.spring.designPattern.structural.FlyweightPattern;

import java.util.HashMap;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-07-11:03
 */
public class WebsiteFactory {

    private HashMap<String,ConcreteWebsite> pool = new HashMap<>();

    public Website getWebsite(String type){
        if(!pool.containsKey(type)){
           pool.put(type,new ConcreteWebsite(type));
        }
        return pool.get(type);
    }

    public int getPoolSize(){
        return pool.size();
    }
}
