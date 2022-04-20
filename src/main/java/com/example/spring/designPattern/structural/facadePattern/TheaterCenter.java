package com.example.spring.designPattern.structural.facadePattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-07-9:30
 */
public class TheaterCenter {
    private DvdPlayer dvdPlayer;
    private Projector projector;
    private TheaterLight light;

    public TheaterCenter() {
        dvdPlayer = DvdPlayer.getInstance();
        projector = Projector.getInstance();
        light = TheaterLight.getInstance();
    }

    public void start(){
        dvdPlayer.open();
        projector.open();
        light.open();
    }

    public void close(){
        dvdPlayer.close();
        projector.close();
        light.close();
    }
}
