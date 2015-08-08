package com.practice.designPattern.strategy;

/**
 * Created by abhi.pandey on 8/2/15.
 */
public class Game {
    public static void main(String[] args) {
        King k = new King();
        k.display();
        k.fight();
        k.setWeapon(new KnifeBehaviour());
        k.fight();
        Queen q = new Queen();
        q.display();
        q.fight();
        q.setWeapon(new SwordBehaviour());
        q.fight();

    }
}
