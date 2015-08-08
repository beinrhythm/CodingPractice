package com.practice.designPattern.strategy;

/**
 * Created by abhi.pandey on 8/2/15.
 */

/**
 * Knife behavior implementation for the characters that uses Knife
 */
public class KnifeBehaviour implements WeaponBehaviour{

    public void useWeapon() {
        System.out.println("I am knife. I can cut");
    }
}
