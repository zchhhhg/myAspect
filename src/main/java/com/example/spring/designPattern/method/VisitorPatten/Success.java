package com.example.spring.designPattern.method.VisitorPatten;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-08-11:06
 */
public class Success implements Action {
    @Override
    public void getManResult() {
        System.out.println("男人给了成功");
    }

    @Override
    public void getWomanResult() {
        System.out.println("女给了成功");
    }
}
