package com.example.spring.designPattern.structural.adapterPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-01-16:48
 */
public interface Controller {
}

class HttpController implements Controller{
    public void doHttpHandle(){
        System.out.println("http......");
    }
}
class SimpleController implements Controller{
    public void doSimpleHandle(){
        System.out.println("simple......");
    }
}
class AnnotationController implements Controller{
    public void doAnnotationHandle(){
        System.out.println("annotation......");
    }
}
