package com.practice.random;

/**
 * Created by abhi.pandey on 11/1/15.
 */
public class Cat implements Animal{

    @Override
    public void run() {
        System.out.println("Cat is running");
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }
}

