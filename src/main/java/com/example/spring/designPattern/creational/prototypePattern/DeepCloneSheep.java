package com.example.spring.designPattern.creational.prototypePattern;

import java.io.*;

/**
 * @author zhoucheng
 * @description 原型模式
 * 1.clone方法中手动处理实现深拷贝
 * 2.使用序列化实现深拷贝
 * 优：简化对象的创建过程，不用重新初始化对象而是动态的获取对象的运行状态，原始对象发生变化（增加或减少属性）其他克隆对象也会发生相应的变化
 * 缺：需要为每一个类配备一个克隆方法，对于老旧的类改造过于繁琐
 * @date 2022-03-31-19:34
 */
public class DeepCloneSheep implements Serializable,Cloneable {


    private String name;
    private Sheep sheep;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        deep = super.clone(); // 先用父类的clone完成基本数据类型和String的复制
        DeepCloneSheep deepSheep = (DeepCloneSheep)deep;
        // 引用类型的单独处理
        deepSheep.sheep = (Sheep) sheep.clone();
        return deepSheep;
    }

    @Override
    public String toString() {
        return "DeepCloneSheep{" +
                "name='" + name + '\'' +
                ", sheep=" + sheep +
                '}';
    }

    // 反序列化实现深拷贝
    public Object deepClone(){
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            bis=new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepCloneSheep sheep = (DeepCloneSheep) ois.readObject();
            return sheep;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
