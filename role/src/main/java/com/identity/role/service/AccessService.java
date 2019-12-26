package com.identity.role.service;

import com.identity.role.bean.User;
import com.identity.role.cache.TemporaryCache;
import org.springframework.stereotype.Service;

@Service
public class AccessService implements AccessServiceInterface {

    @Override
    public User[] getAllAccess() {
        return new User[0];
    }

    @Override
    public User getAllAccess(long id) {

        return TemporaryCache.cacheMap.get(id);
    }

    @Override
    public User deleteUserAccess(long id) {
        return TemporaryCache.removeFromCache(id);
    }

    @Override
    public User addUserAccess(User user) {
        return TemporaryCache.addToCache(user);
    }

    @Override
    public User editUserAccess(User user) {
        return TemporaryCache.editCache(user);
    }
}
