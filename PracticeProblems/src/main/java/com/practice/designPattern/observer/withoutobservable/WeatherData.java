package com.practice.designPattern.observer.withoutobservable;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhi.pandey on 8/2/15.
 */

public class WeatherData implements Subject {

    private List<Observer> listOfObserver;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        listOfObserver = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        listOfObserver.add(o);

    }

    @Override
    public void deleteObserver(Observer o) {
        int i = listOfObserver.indexOf(o);
        if (i >= 0) {
            listOfObserver.remove(i);
        }

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : listOfObserver) {
            observer.update(temperature, humidity, pressure);

        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    private void measurementsChanged() {
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
