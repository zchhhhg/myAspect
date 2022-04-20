package com.example.spring.designPattern.creational.singletonPattern;

/**
 * @author zhoucheng
 * @description 单例模式
 * @date 2022-03-31-10:06
 */
public class SingletonPattern05 {
    public static void main(String[] args) {
        Singleton05 singleton1 = Singleton05.getSingletonInstance();
        Singleton05 singleton2 = Singleton05.getSingletonInstance();
        System.out.println(singleton1==singleton2);
    }
}

/**
 * 双重检查
 * 优：懒加载，线程安全，效率也不低
 */
class Singleton05{
    // 构造器私有化，避免外部能new本对象的示例
    private Singleton05(){

    }
    // 内部创建实例对象
    // volatile instance发生变更立刻更新到主存
    private static volatile Singleton05 instance;

    // 提供一个公用的静态方法，返回实例对象
    // 同步代码块+双重检查
    public static Singleton05 getSingletonInstance(){
        if(instance==null){
            synchronized (Singleton05.class){
                if(instance==null){
                    instance = new Singleton05();
                }
            }
        }
        return instance;
    }
}
