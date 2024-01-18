package com.uit.user.repository;

import com.uit.common.model.User;
import com.uit.common.repository.CommonRepository;
import com.uit.common.repository.UserRepository;
import com.uit.user.model.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserDTORepository extends UserRepository, CommonRepository<UserDTO, String>, MongoRepository<UserDTO, String> {
    Optional<User> findByEmail(String email);
}
