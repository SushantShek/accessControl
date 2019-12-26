package com.identity.role.cache;

import com.identity.role.bean.User;

import java.util.concurrent.ConcurrentHashMap;

public class TemporaryCache {

    public static ConcurrentHashMap<Long, User> cacheMap = new ConcurrentHashMap<>();

    static long increment = 1L;

    static {
        cacheMap.put(increment + 1, new User());
    }

    public static User addToCache(Object val) {
        if(val !=null){
        return cacheMap.put(increment + 1, (User) val);}
        return null;
    }

    public static User removeFromCache(long id) {
        if (cacheMap.contains(id)) {
            return cacheMap.remove(id);
        }
        return null;
    }

    public static User editCache(Object val) {
        if (val != null) {
            User usr = (User) val;
            if (cacheMap.contains(usr.getId())) {
                return cacheMap.put(usr.getId(), usr);
            }
        }
        return null;
    }

}
