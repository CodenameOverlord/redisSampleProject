package com.redisProject.coTech.controller;

import com.redisProject.coTech.model.User;
import com.redisProject.coTech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User user){
        boolean result = userService.saveUser(user);
        if(result){
            return new ResponseEntity<>("User stored successfully", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.fetchAllUsers();
        if(users!=null && users.size()>0){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>("no users found", HttpStatus.OK);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> fetchUserById(@PathVariable(name = "userId") long userId){
        User user = userService.fetchUsersFromUserId(userId);
        if(user!=null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("no such user found", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserByUserId(@PathVariable(name = "userId") long userId){
        Boolean r = userService.deleteUserByUserId(userId);
        if(r==false){
            return new ResponseEntity<>("success deleting user", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("failure deleting user", HttpStatus.BAD_REQUEST);
        }
    }
}
