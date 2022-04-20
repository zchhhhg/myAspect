package com.example.spring.designPattern.creational.prototypePattern;

import java.io.Serializable;

/**
 * @author zhoucheng
 * @description 原型模式应用--克隆羊 --浅拷贝
 * 对于数据类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，将属性值复制一份给新的对象(包含字符串)
 * 对于引用数据类型的成员变量则只复制引用值（内存地址）
 * @date 2022-03-31-18:51
 */
public class CloneSheep {
    public static void main(String[] args) throws CloneNotSupportedException {
        testSerializableDeepCloneSheep();
    }

    public static void testCloneSheep() throws CloneNotSupportedException {
        Sheep sheep = new Sheep("123", "克隆羊羊羊羊", "母的", "青青草原", new int[2]);
        Sheep sheep1 = (Sheep) sheep.clone();
        System.out.println(sheep);
        System.out.println(sheep1);
        System.out.println(sheep.hashCode());
        System.out.println(sheep1.hashCode());
        System.out.println(sheep.getArray().hashCode());
        System.out.println(sheep1.getArray().hashCode());
    }

    public static void testDeepCloneSheep() throws CloneNotSupportedException {
        DeepCloneSheep sheep = new DeepCloneSheep();
        sheep.setName("qwer");
        sheep.setSheep(new Sheep("123", "克隆羊羊羊羊", "母的", "青青草原", new int[2]));
        DeepCloneSheep sheep1 = (DeepCloneSheep) sheep.clone();
        System.out.println(sheep.hashCode());
        System.out.println(sheep1.hashCode());
        System.out.println(sheep.getSheep().hashCode());
        System.out.println(sheep1.getSheep().hashCode());

    }

    public static void testSerializableDeepCloneSheep() throws CloneNotSupportedException {
        DeepCloneSheep sheep = new DeepCloneSheep();
        sheep.setName("qwer");
        sheep.setSheep(new Sheep("123", "克隆羊羊羊羊", "母的", "青青草原", new int[2]));
        DeepCloneSheep sheep1 = (DeepCloneSheep) sheep.deepClone();
        System.out.println(sheep.hashCode());
        System.out.println(sheep1.hashCode());
        System.out.println(sheep.getSheep().hashCode());
        System.out.println(sheep1.getSheep().hashCode());
    }
}
