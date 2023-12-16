package com.redisProject.coTech.repository;

import com.redisProject.coTech.model.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> fetchAllUsers();



    boolean deleteUserById(Long userId);

    User fetchUserByUserId(long userId);
}
