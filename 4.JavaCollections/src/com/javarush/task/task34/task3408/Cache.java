package com.javarush.task.task34.task3408;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (!cache.containsKey(key))
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));

        return cache.get(key);
    }

    public boolean put(V obj) {
        try {
            Method getKeyMeth = obj.getClass().getDeclaredMethod("getKey");
            getKeyMeth.setAccessible(true);
            K k = (K) getKeyMeth.invoke(obj);
            cache.put(k, obj);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
