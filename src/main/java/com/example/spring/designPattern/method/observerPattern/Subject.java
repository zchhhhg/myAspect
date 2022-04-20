package com.example.spring.designPattern.method.observerPattern;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifybserver();
}
