package com.practice.miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhi.pandey on 3/11/15.
 */
public class CakeThief {

    public static int maxBagValue(List<Cake> cakes, int capacity) {


        int[] maxValuesAtCapacities = new int[capacity];

        for (int currentCapacity : maxValuesAtCapacities) {


            int currentMaxValue = 0;

            for (Cake cake : cakes) {


                if (cake.weight == 0 && cake.value != 0) {
                    System.out.println("Infinity");
                }

                if (cake.weight <= capacity) {

                    int maxValueUsingCake = cake.value + maxValuesAtCapacities[capacity - cake.weight];

                    currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);

                }

                maxValuesAtCapacities[currentCapacity] = currentMaxValue;
            }

        }
        return maxValuesAtCapacities[capacity];
    }


    public static void main(String[] args) {
        List<Cake> cakes = new ArrayList<>();

        cakes.add(new Cake(7, 160));
        cakes.add(new Cake(3, 90));
        cakes.add(new Cake(2, 15));
        System.out.println(maxBagValue(cakes, 20));


    }
}

class Cake {
    int value;
    int weight;

    public Cake(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }


}
