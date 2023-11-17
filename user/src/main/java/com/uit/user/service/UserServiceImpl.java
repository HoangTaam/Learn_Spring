package com.uit.user.service;

import com.uit.common.model.User;
import com.uit.user.repository.AuthenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private AuthenRepository authenRepository;
    @Override
    public User userLogin(String userName, String userPassWord) {
        User user = new User();
        user.setUserName(userName);
        user.setUserPassWord(userPassWord);
        return authenRepository.save(user);
    }
}
