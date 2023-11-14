package com.uit.user.services;

import com.uit.common.models.User;

public interface UserService {
    public User userLogin(String userName, String userPassWord);
}
