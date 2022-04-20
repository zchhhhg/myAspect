package com.example.spring.designPattern.creational.singletonPattern;

/**
 * @author zhoucheng
 * @description 单例模式
 * @date 2022-03-31-10:06
 */
public class SingletonPattern07 {
    public static void main(String[] args) {
        Singleton07 singleton1 = Singleton07.instance;
        Singleton07 singleton2 = Singleton07.instance;
        System.out.println(singleton1==singleton2);
    }
}

/**
 * 枚举
 * 优：懒加载，线程安全，效率高，还能防止反序列化重新创建新的对象
 */
enum Singleton07{
    instance;
}
