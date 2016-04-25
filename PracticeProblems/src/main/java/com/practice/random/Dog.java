package com.practice.random;

/**
 * Created by abhi.pandey on 11/1/15.
 */
public class Dog implements Animal{

    @Override
    public void run() {
        System.out.println("Dog is running");
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }
    static int num = 20;

}
