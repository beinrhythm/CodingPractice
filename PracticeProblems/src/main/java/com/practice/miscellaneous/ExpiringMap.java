package com.practice.miscellaneous;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by abhi.pandey on 3/1/16.
 */
public class ExpiringMap<K, V> {

    ConcurrentHashMap<K, V> internalMap = new ConcurrentHashMap<>();


    public V get(Object key) {
        return internalMap.get(key);
    }


    public V put(K key, V value, long timeToLive) {

        return internalMap.put(key, value);
    }
}
