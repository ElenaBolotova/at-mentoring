package com.epam.elena_bolotova.mentoring.task9.framework.util;

import com.epam.elena_bolotova.mentoring.task9.tests.business_objects.User;

public class UserUtils {

    public static final User createUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
