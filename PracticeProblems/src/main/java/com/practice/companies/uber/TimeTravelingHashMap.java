package com.practice.companies.uber;


import java.util.HashMap;
import java.util.TreeMap;

/**
 * TimeTravelingHashTable (asked in phone screening) - Add a third dimension of time to a hashmap ,
 * so ur hashmap will look something like this - HashMap<K, t, V> where t is a float value.
 * Implement the get and put methods to this map. The get method should be something like
 * - map.get(K,t) which should give us the value. If t does not exists then map should
 * return the closest t' such that t' is smaller than t. For example, if map contains (K,1,V1) and (K,2,V2)
 * and the user does a get(k,1.5) then the output should be v1 as 1 is the next smallest number to 1.5
 * <p/>
 * Created by abhi.pandey on 3/29/16.
 */

class TimeTravelingHashMap<K, V> {
    private HashMap<K, TreeMap<Double, V>> internalMap = new HashMap<K, TreeMap<Double, V>>();

    void set(double time, K key, V val) {
        // look if the key is present in the map
        if (!internalMap.containsKey(key)) {
            //if key is not found, insert the key with new treemap
            internalMap.put(key, new TreeMap<Double, V>());
        }
        // get the treemap related to that key and append the latest time with the value
        internalMap.get(key).put(time, val);
    }

    V get(double time, K key) {
        final TreeMap<Double, V> temp = internalMap.get(key);
        // if there is no key in the map, return null
        if (temp == null) {
            return null;
        }

        // Get the floor key of the internal treemap, which is the greatest time < inputted time
        final Double fKey = temp.floorKey(time);

        // If the floor key is null, meaning there is no time < inputted time, return null
        if (fKey == null) {
            return null;
        }

        // return the latest value
        return temp.get(fKey);

    }

    V get(K key) {
        final TreeMap<Double, V> temp = internalMap.get(key);
        // if there is no key in the map, return null
        if (temp == null) {
            return null;
        }

        // Get the highest key of the internal treemap
        final Double lastKey = temp.lastKey();

        // If the last key is null, return null
        if (lastKey == null) {
            return null;
        }

        // return the latest value
        return temp.get(lastKey);
    }

    public static void main(String[] args) {
        TimeTravelingHashMap<String, String> ttht = new TimeTravelingHashMap<>();

        ttht.set(0.0, "foo", "A");
        ttht.set(1.0, "foo", "B");
        ttht.set(2.0, "foo", "C");

        ttht.set(3.0, "bar", "Z");
        ttht.set(1.2, "bar", "Y");
        ttht.set(-1.2, "bar", "X");

        System.out.println(ttht.get("foo").matches("C"));
        System.out.println(ttht.get("bar").matches("Z"));

        System.out.println(ttht.get(0.0, "foo").matches("A"));
        System.out.println(ttht.get(0.0, "bar").matches("X"));

        System.out.println(ttht.get(1.0, "foo").matches("B"));
        System.out.println(ttht.get(1.0, "bar").matches("X"));

        System.out.println(ttht.get(2.0, "foo").matches("C"));
        System.out.println(ttht.get(2.0, "bar").matches("Y"));

        System.out.println(ttht.get(3.0, "foo").matches("C"));
        System.out.println(ttht.get(3.0, "bar").matches("Z"));

        System.out.println(ttht.get(-1.0, "foo") == null);
        System.out.println(ttht.get(-1.0, "bar").matches("X"));
    }
}