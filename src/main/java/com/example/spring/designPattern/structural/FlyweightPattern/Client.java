package com.example.spring.designPattern.structural.FlyweightPattern;

/**
 * @author zhoucheng
 * @description 享元模式
 * 也叫蝇量模式，运用共享技术有效的支持大量细粒度的对象
 * 内部状态：指对象共享出来的信息，存储在享元对象内部且不会随环境的改变而改变
 * 外部状态：对象得以依赖的一个标记，随环境的改变而改变，不可共享的状态
 * 应用场景：String常量池 数据库连接池
 * @date 2022-04-07-10:51
 */
public class Client {
    public static void main(String[] args) {
        WebsiteFactory factory = new WebsiteFactory();
        Website website1 = factory.getWebsite("hahaha");
        Website website2 = factory.getWebsite("haha");
        Website website3 = factory.getWebsite("haha");

        website1.use(new User("zls"));
        website2.use(new User("zlshhg"));
        website3.use(new User("zlshhhhg"));

        System.out.println(factory.getPoolSize());
    }
}
