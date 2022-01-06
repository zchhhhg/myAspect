package com.example.spring.business;

/**
 * @author Cheng
 * @date 2021-09-08-10:32
 */
public interface IService {
    void getCache();
    void publishEvent();
    void generateSqlScript(String MENU_ID) throws Exception;
}
