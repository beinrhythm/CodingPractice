package com.practice.multiThreading.delayQueue;


import java.util.Map;

/**
 *
 * Created by abhi.pandey on 3/1/16.
 *
 * @param <K> the Key type
 * @param <V> the Value type
 */
public interface SelfExpiringMap<K, V> extends Map<K, V> {

    /**
     * Renews the specified key, setting the life time to the initial value.
     *
     * @param key
     * @return true if the key is found, false otherwise
     */
    public boolean renewKey(K key);

    /**
     * Associates the given key to the given value in this map, with the specified life
     * times in milliseconds.
     *
     * @param key
     * @param value
     * @param lifeTimeMillis
     * @return a previously associated object for the given key (if exists).
     */
    public V put(K key, V value, long lifeTimeMillis);

}