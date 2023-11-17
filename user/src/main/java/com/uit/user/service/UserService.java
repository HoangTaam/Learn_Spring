package com.uit.user.service;

import com.uit.common.model.User;

public interface UserService {
    public User userLogin(String userName, String userPassWord);
}
