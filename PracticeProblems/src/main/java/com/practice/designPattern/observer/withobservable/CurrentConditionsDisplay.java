package com.practice.designPattern.observer.withobservable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by abhi.pandey on 8/2/15.
 */

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Observable observable;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof WeatherData){
            WeatherData data = (WeatherData) o;
            temperature = data.getTemperature();
            humidity = data.getHumidity();
            display();
        }

    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }
}
