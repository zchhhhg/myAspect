package com.example.spring.designPattern.creational.singletonPattern;

/**
 * @author zhoucheng
 * @description 单例模式
 * @date 2022-03-31-10:06
 */
public class SingletonPattern03 {
    public static void main(String[] args) {
        Singleton03 singleton1 = Singleton03.getSingletonInstance();
        Singleton03 singleton2 = Singleton03.getSingletonInstance();
        System.out.println(singleton1==singleton2);
    }
}

/**
 * 懒汉式（线程不安全）
 * 优：使用时才创建，避免了内存浪费问题
 * 缺：存在线程安全问题，多线程开发中不能使用这种方式
 */
class Singleton03{
    // 构造器私有化，避免外部能new本对象的示例
    private Singleton03(){

    }
    // 内部创建实例对象
    private static Singleton03 instance;

    // 提供一个公用的静态方法，返回实例对象
    public static Singleton03 getSingletonInstance(){
        if(instance==null){
            instance = new Singleton03();
        }
        return instance;
    }
}
