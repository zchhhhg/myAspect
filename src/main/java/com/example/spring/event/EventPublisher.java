package com.example.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Cheng
 * @date 2021-03-10-12:45
 */
@Component
public class EventPublisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void publish(Map<String, Object> param, String type){
        MyEvent myEvent = new MyEvent(param);
        myEvent.setType(type);
        myEvent.setParam(param);
        applicationContext.publishEvent(myEvent);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
