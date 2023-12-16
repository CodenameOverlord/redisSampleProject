package com.redisProject.coTech.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
//@JsonSerialize
public class User implements Serializable {
    private Long id;
    private String firstname;
    private String lastname;
    private String emailId;
    private Integer age;

//    public static User convertToUser(Object o) {
//        HashMap<String, Object> hmap = (HashMap<String, Object>) o;
//        User user = new User();
//        user.setAge((Integer)hmap.get("age"));
//        user.setFirstname((String)hmap.get("firstname"));
//        user.setLastname ((String)hmap.get("lastname"));
//        user.setEmailId((String)hmap.get("emailId"));
//        user.setId((Long)hmap.get("id"));
//        return user;
//    }
}
