package com.example.spring.designPattern.creational.singletonPattern;

/**
 * @author zhoucheng
 * @description 单例模式
 * @date 2022-03-31-10:06
 */
public class SingletonPattern06 {
    public static void main(String[] args) {
        Singleton06 singleton1 = Singleton06.getSingletonInstance();
        Singleton06 singleton2 = Singleton06.getSingletonInstance();
        System.out.println(singleton1==singleton2);
    }
}

/**
 * 双重检查
 * 优：懒加载，线程安全，效率高
 */
class Singleton06{
    // 构造器私有化，避免外部能new本对象的示例
    private Singleton06(){

    }
    // 静态内部类装载对象
    // 外部类装载的时候，静态内部类不会跟着立即装载；而且线程安全
    private static class SingtonInstance {
        private static Singleton06 instance = new Singleton06();
    }

    // 提供一个公用的静态方法，返回实例对象
    public static Singleton06 getSingletonInstance(){
        return SingtonInstance.instance;
    }
}
