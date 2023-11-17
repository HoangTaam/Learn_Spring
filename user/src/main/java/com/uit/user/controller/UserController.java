package com.uit.user.controller;

import com.uit.common.dto.GeneralApiResponse;
import com.uit.common.model.User;
import com.uit.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
