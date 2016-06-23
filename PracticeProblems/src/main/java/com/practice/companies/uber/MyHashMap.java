/*
package com.practice.companies.uber;

*/
/**
 * Created by abhi.pandey on 5/12/16.
 *//*

public class MyHashMap<K, V> {
    private double loadFactor = 0.75;

    private Entry[] table;

    private int elemCount;


    public static class Entry {
        K key;
        V value;
        Entry<K, V> next;


//contructors, getters and setters below

    }

    */
/**
     * Insert your super-mega-hash-function below :)
     *//*

    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public void put(K key, V value) {
        if (elemCount > table.length * loadFactor) resize();
        int index = hash(key.hashCode()) % table.length;
        if (table[index] == null) table[index] = new Entry(key, value);
        else {
            Entry cur = table[index];
            while (true) {
                if (cur.getKey().equals(key)) {
                    cur.setValue(value);
                    break;
                }
                if (cur.next() == null) break;
                cur = cur.next();
            }
            cur.setNext(new Entry(key, value));
        }
    }

    public V get(K key) {
        int index = hash(key.hashCode()) % table.length;
        if (table[index] == null) return null;
        else {
            Entry cur = table[index];
            while (true) {
                if (cur.getKey().equals(key)) {
                    return cur.getValue();
                }
                if (cur.next() == null) break;
                cur = cur.next();
            }
            return null;
        }
    }

    public void resize() {
        double newSize = table.length * 1.5;
        Entry[] newTable = new Entry[newSize];
        for (int i = 0; i < table.length; i++) newTable[i] = table[i];
        table = newTable;
    }

//contructors, getters and setters below

}

*/
