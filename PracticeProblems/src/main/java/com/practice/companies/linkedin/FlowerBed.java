package com.practice.companies.linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die. Given a flowerbed (represented as an array containing booleans), return if a given number of new flowers can be planted in it without violating the no-adjacent-flowers rule
 * Sample inputs
 * <p/>
 * Input: 1,0,0,0,0,0,1,0,0
 * <p/>
 * 3 => true
 * 4 => false
 * Input: 1,0,0,1,0,0,1,0,0
 * <p/>
 * 1 => true
 * 2 => false
 * input: 0
 * <p/>
 * 1 => true
 * 2 => false
 * <p/>
 * Created by abhi.pandey on 4/4/16.
 */
public class FlowerBed {

    public boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace) {
        if (flowerbed.size() == 0) return false;
        if (numberToPlace == 0) return true;

        // Count if we can place an adjacent flower
        int countCanPlaceFlower = 0;
        // condtion to check if adjacent flower can be set
        boolean prev = flowerbed.get(0);
        // check the next index
        // increment the count if current and
        // previous flags are false
        // if current flag is true decrement count
        for (Boolean next : flowerbed) {
            if (!next && !prev)
                countCanPlaceFlower++;
            else if (next)
                countCanPlaceFlower--;
            prev = next;
        }
        System.out.println(countCanPlaceFlower);
        // compare count to numbertoPlace -> return result
        if (countCanPlaceFlower >= numberToPlace)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        List<Boolean> input = new ArrayList<>();
        input.add(true);
        input.add(false);
        input.add(false);
        input.add(false);
        input.add(false);
        input.add(false);
        input.add(true);
        input.add(false);
        input.add(false);

        int target = 2;
        System.out.println(new FlowerBed().canPlaceFlowers(input, target));
    }

}
