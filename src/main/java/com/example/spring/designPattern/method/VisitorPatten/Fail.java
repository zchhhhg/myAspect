package com.example.spring.designPattern.method.VisitorPatten;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-08-11:07
 */
public class Fail implements Action {
    @Override
    public void getManResult() {
        System.out.println("男人给了失败");
    }

    @Override
    public void getWomanResult() {
        System.out.println("女人给了失败");
    }
}
