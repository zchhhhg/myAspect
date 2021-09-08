package com.example.spring.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * @author Cheng
 * @date 2021-03-10-12:37
 */

public class MyEvent extends ApplicationEvent {
    private String type;
    private Map<String, Object> param;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MyEvent(Object source) {
        super(source);
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }
}
