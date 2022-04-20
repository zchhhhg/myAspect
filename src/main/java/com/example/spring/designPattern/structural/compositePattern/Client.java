package com.example.spring.designPattern.structural.compositePattern;

/**
 * @author zhoucheng
 * @description 组合模式
 * 简化客户端操作，客户只需要面对一致的对象而不用考虑整体部分或者叶子节点的问题
 * 方便构建复杂的层次结构，且组合内的结构客户端无需了解
 * 可扩展性强，当更改组合对象时只需调整内部的层级关系
 *
 * 如果各节点有较强的差异性不方便统一的话则不适用使用组合模式
 * @date 2022-04-06-20:22
 */
public class Client {
    public static void main(String[] args) {
        Organization university = new University("国防科技大学", "国防科技大学");
        Organization college = new College("计算机学院","计算机学院");
        Organization department1 = new Department("计算机科学","计算机科学");
        Organization department2 = new Department("软件工程","软件工程");
        university.add(college);
        college.add(department1);
        college.add(department2);
        college.print();
    }
}
