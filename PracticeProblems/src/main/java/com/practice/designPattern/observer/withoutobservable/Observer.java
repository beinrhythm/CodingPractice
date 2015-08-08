package com.practice.designPattern.observer.withoutobservable;

/**
 * Created by abhi.pandey on 8/2/15.
 */
public interface Observer {
    public void update(float temperature, float humidity, float pressure);
}
