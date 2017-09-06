package com.epam.elena_bolotova.mentoring.task8.framework.util;

import com.epam.elena_bolotova.mentoring.task8.tests.gmail.bo.User;

public class UserUtils {

    public static final User createUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
