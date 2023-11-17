package com.uit.user.repository;

import com.uit.common.model.User;
import com.uit.common.repository.CommonRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends CommonRepository<User, Integer>, MongoRepository<User,Integer> {
    Optional<User> findByEmail(String email)
}
