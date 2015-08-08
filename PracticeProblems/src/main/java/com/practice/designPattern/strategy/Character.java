package com.practice.designPattern.strategy;

/**
 * Created by abhi.pandey on 8/1/15.
 */

/**
 * abstract class that every character has to extend
 */
public abstract class Character {

    //reference behavior for the behaviour reference type. All characters subclass will inherit this
    public WeaponBehaviour weapon;

    // delegate to the behaviour class
    public void fight(){
        weapon.useWeapon();
    }

    public abstract void display();

    public void setWeapon(WeaponBehaviour weapon) {
        this.weapon = weapon;
    }
}
