package com.example.spring.business;

import com.example.spring.aspect.CacheRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cheng
 * @date 2021-09-08-10:32
 */
@RestController
public class MyController {

    @Autowired
    private IService service;

    @RequestMapping(path = "/hello")
    @CacheRedis(key = "mycache")
    public String helloWorld(){
        service.getCache();
        return "success";
    }

    @RequestMapping(path = "/cache")
    public String getCache(){
        service.getCache();
        return "success";
    }
}
