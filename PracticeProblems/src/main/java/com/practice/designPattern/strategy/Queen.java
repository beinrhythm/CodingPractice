package com.practice.designPattern.strategy;

/**
 * Created by abhi.pandey on 8/2/15.
 */
public class Queen extends Character{

    public Queen() {
        weapon = new KnifeBehaviour();
    }

    @Override
    public void display() {
        System.out.println("I am a queen");
    }
}
