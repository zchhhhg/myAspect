package com.example.spring.designPattern.creational.singletonPattern;

/**
 * @author zhoucheng
 * @description 单例模式
 * @date 2022-03-31-10:06
 */
public class SingletonPattern01 {
    public static void main(String[] args) {
        Singleton01 singleton1 = Singleton01.getSingletonInstance();
        Singleton01 singleton2 = Singleton01.getSingletonInstance();
        System.out.println(singleton1==singleton2);
    }
}

/**
 * 饿汉式（静态常量）
 * 优：在类装载的时候就完成了实例化，避免了线程同步问题
 * 缺：没有达到懒加载的效果，类装载的时候就完成实例化，如果从始至终没用过这个实例就造成了内存的浪费
 */
class Singleton01{
    // 构造器私有化，避免外部能new本对象的示例
    private Singleton01(){

    }
    // 内部创建实例对象
    private final static Singleton01 instance = new Singleton01();

    // 提供一个公用的静态方法，返回实例对象
    public static Singleton01 getSingletonInstance(){
        return instance;
    }
}
