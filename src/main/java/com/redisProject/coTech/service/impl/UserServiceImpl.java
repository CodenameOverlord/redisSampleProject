package com.redisProject.coTech.service.impl;

import com.redisProject.coTech.model.User;
import com.redisProject.coTech.repository.UserDao;
import com.redisProject.coTech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return userDao.fetchAllUsers();
    }


    @Override
    public User fetchUsersFromUserId(long userId) {
        return userDao.fetchUserByUserId(userId);
    }

    @Override
    public Boolean deleteUserByUserId(long userId) {
        return userDao.deleteUserById(userId);
    }
}
