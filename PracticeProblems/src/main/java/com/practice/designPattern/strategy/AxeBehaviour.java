package com.practice.designPattern.strategy;

/**
 * Created by abhi.pandey on 8/2/15.
 */

/**
 * Axe behavior implementation for the characters that uses Axe
 */
public class AxeBehaviour implements WeaponBehaviour {
    public void useWeapon() {
        System.out.println("I am Axe, I can chop");
    }
}
