package com.example.spring.designPattern.structural.bridgePattern;

/**
 * @author zhoucheng
 * @description 桥接模式
 * 将实现与抽象放到两个不同的类层次中，使两个层次可以独立改变
 * 品牌有华为小米三星等，样式又有折叠屏全面屏等等，使用桥接式可以在新增手机品牌的时候不用每个样式都添加一个相应的类
 * JDBC的Driver接口就是用的桥接模式，可以有Mysql，Oracle，Sqlserver的Driver
 * @date 2022-04-06-10:24
 */
public class Client {
    public static void main(String[] args) {
        FolderPhone phone = new FolderPhone(new XiaomiBrand());
        phone.open();
        phone.call();
    }
}
