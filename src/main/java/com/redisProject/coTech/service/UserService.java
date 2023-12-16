package com.redisProject.coTech.service;

import com.redisProject.coTech.model.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);

    List<User> fetchAllUsers();


    Boolean deleteUserByUserId(long userId);

    User fetchUsersFromUserId(long userId);
}
