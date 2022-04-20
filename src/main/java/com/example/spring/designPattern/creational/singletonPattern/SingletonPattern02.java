package com.example.spring.designPattern.creational.singletonPattern;

/**
 * @author zhoucheng
 * @description 单例模式
 * @date 2022-03-31-10:06
 */
public class SingletonPattern02 {
    public static void main(String[] args) {
        Singleton02 singleton1 = Singleton02.getSingletonInstance();
        Singleton02 singleton2 = Singleton02.getSingletonInstance();
        System.out.println(singleton1==singleton2);
    }
}

/**
 * 饿汉式（静态代码块）和静态常量的效果一样
 * 优：在类装载的时候就完成了实例化，避免了线程同步问题
 * 缺：没有达到懒加载的效果，类装载的时候就完成实例化，如果从始至终没用过这个实例就造成了内存的浪费
 */
class Singleton02{
    // 构造器私有化，避免外部能new本对象的示例
    private Singleton02(){

    }

    private static Singleton02 instance;

    // 静态代码块中创建实例对象
    static {
        instance = new Singleton02();
    }

    // 提供一个公用的静态方法，返回实例对象
    public static Singleton02 getSingletonInstance(){
        return instance;
    }
}
