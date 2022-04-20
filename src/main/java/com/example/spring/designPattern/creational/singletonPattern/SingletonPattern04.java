package com.example.spring.designPattern.creational.singletonPattern;

/**
 * @author zhoucheng
 * @description 单例模式
 * @date 2022-03-31-10:06
 */
public class SingletonPattern04 {
    public static void main(String[] args) {
        Singleton04 singleton1 = Singleton04.getSingletonInstance();
        Singleton04 singleton2 = Singleton04.getSingletonInstance();
        System.out.println(singleton1==singleton2);
    }
}

/**
 * 懒汉式（线程安全）
 * 优：使用时才创建，避免了内存浪费问题，同时解决了线程不安全的问题
 * 缺：效率太低，每次都需要进行同步判断，不推荐使用
 */
class Singleton04{
    // 构造器私有化，避免外部能new本对象的示例
    private Singleton04(){

    }
    // 内部创建实例对象
    private static Singleton04 instance;

    // 提供一个公用的静态方法，返回实例对象
    // 加入同步处理synchronized关键字，保证每次只有一个线程能进入
    public static synchronized Singleton04 getSingletonInstance(){
        if(instance==null){
            instance = new Singleton04();
        }
        return instance;
    }
}
