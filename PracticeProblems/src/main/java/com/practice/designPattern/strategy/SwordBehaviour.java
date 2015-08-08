package com.practice.designPattern.strategy;

/**
 * Created by abhi.pandey on 8/2/15.
 */

/**
 * Sword behavior implementation for the characters that uses sword
 */
public class SwordBehaviour implements WeaponBehaviour {

    public void useWeapon() {
        System.out.println("I am a sword, I swing");
    }
}
