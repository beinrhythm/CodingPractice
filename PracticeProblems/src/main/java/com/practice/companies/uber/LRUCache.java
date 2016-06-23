package com.practice.companies.uber;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by abhi.pandey on 5/8/16.
 */
public class LRUCache<K, V>  {
    MyMap<K, V> map;

    public LRUCache(int capacity) {
        this.map = new MyMap(capacity);
    }

    public void set(K key, V val) {
        map.put(key, val);
    }

    public V get(K key) {
        V val = map.get(key);

        return (val == null) ? null : val;
    }

    class MyMap<K, V> extends LinkedHashMap<K, V> {
        int capacity;

        public MyMap(int initialCapacity) {
            super(initialCapacity, 0.75f, true);
            this.capacity = initialCapacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }
}
