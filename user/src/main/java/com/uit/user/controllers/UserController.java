package com.uit.user.controllers;

import com.uit.common.dto.GeneralApiResponse;
import com.uit.common.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @PostMapping(value = "/register-user")
    public GeneralApiResponse<User> registerUser(@RequestBody User user){
        return new GeneralApiResponse<>(new User(user.getUserId(), user.getUserName(), user.getUserPassWord()));
    }
}
