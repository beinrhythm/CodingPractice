package com.practice.controller.service;

import com.practice.controller.dao.User;

/**
 * Created by abhi.pandey on 9/24/14.
 */
public class UserService {

    public User getDefaultUser() {
        User user = new User();
        user.setFirstName("Tanvi");
        user.setLastName("vyas");
        return user;
    }
}
