package com.example.spring.business;

import org.springframework.stereotype.Service;

/**
 * @author Cheng
 * @date 2021-09-08-10:32
 */
@Service
public class MyService implements IService {
    @Override
    public void getCache() {
        String result = getCacheResult();
        System.out.println(result);
    }

    public String getCacheResult(){
        return "cache result";
    }
}
