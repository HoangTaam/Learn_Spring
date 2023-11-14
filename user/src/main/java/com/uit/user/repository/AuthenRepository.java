package com.uit.user.repository;

import com.uit.common.models.User;
import com.uit.common.repository.CommonRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthenRepository extends CommonRepository<User, Integer>, MongoRepository<User, Integer> {
}
