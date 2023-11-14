package com.uit.user.controllers;

import com.uit.common.dto.GeneralApiResponse;
import com.uit.common.models.User;
import com.uit.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register-user")
    public GeneralApiResponse<User> registerUser(@RequestBody User user){
        return new GeneralApiResponse<>(new User(user.getUserId(), user.getUserName(), user.getUserPassWord()));
    }
    @PostMapping(value = "/user-login")
    public GeneralApiResponse<User> userLogin(@RequestParam(name = "userName") String userName,
                                              @RequestParam(name = "userPassWord") String userPassWord){
        return new GeneralApiResponse<>(userService.userLogin(userName, userPassWord));
    }
}
