package com.practice.test;

import com.practice.random.Animal;
import com.practice.random.Cat;
import com.practice.random.Dog;

/**
 * Created by abhi.pandey on 11/1/15.
 */
public class Test1 {
    public static void main(String[] args) {
        Animal animal1 = new Cat();
        Animal animal2 = new Dog();

        Test1 t = new Test1();


        t.behaviourEat(animal1);

        Dog dog = (Dog) animal2;
        dog.eat();
    }

    void behaviourEat(Animal animal){
        animal.eat();
    }
    void behaviourRun(Animal animal){
        animal.run();
    }
}
