package com.identity.role.service;

import com.identity.role.bean.User;

public interface AccessServiceInterface {
   User[] getAllAccess();
   User getAllAccess(long id);
   User deleteUserAccess(long id);
   User addUserAccess(User user);
   User editUserAccess(User user);
}
