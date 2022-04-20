package com.example.spring.designPattern.creational.prototypePattern;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author zhoucheng
 * @description 实现Cloneable接口重写clone方法后便可被克隆
 * @date 2022-03-31-18:49
 */
public class Sheep implements Cloneable, Serializable {

    private String userId;

    private String userName;

    private String userSex;

    private String userAdress;

    private int[] array;

    public Sheep(String userId, String userName, String userSex, String userAdress, int[] array) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userAdress = userAdress;
        this.array = array;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAdress='" + userAdress + '\'' +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
