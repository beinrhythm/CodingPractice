package com.practice.controller.server;

import com.google.common.collect.Lists;
import com.practice.controller.dao.User;
import com.practice.controller.service.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by abhi.pandey on 9/24/14.
 */
@Path("users")
public class UserRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getDefaultUserInJSON() {
        List<User> users = Lists.newArrayList();
        UserService userService = new UserService();
        users.add( userService.getDefaultUser());
        users.add( userService.getDefaultUser());
        return users;
    }
}

