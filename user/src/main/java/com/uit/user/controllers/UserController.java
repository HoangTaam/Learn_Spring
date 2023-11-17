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

    @PostMapping(value = "/user-login")
    public GeneralApiResponse<User> userLogin(@RequestParam(name = "userName") String userName,
                                              @RequestParam(name = "userPassWord") String userPassWord){
        return new GeneralApiResponse<>(userService.userLogin(userName, userPassWord));
    }
}
