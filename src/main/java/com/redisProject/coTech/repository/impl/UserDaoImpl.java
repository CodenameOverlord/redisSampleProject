package com.redisProject.coTech.repository.impl;

import com.redisProject.coTech.model.User;
import com.redisProject.coTech.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER";
    @Override
    public boolean saveUser(User user) {
        try {
            redisTemplate.opsForHash().put(KEY, String.valueOf(user.getId()), user);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<User> fetchAllUsers() {
        List<User> users = redisTemplate.opsForHash().values(KEY);
        return users;
    }



    @Override
    public boolean deleteUserById(Long userId) {
        try{
            redisTemplate.opsForHash().delete(KEY, userId.toString());
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User fetchUserByUserId(long userId) {
        try{
            User user = (User) redisTemplate.opsForHash().get(KEY, String.valueOf(userId));
            return user;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
