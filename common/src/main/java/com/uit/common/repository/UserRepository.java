package com.uit.common.repository;

import com.uit.common.model.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
}
