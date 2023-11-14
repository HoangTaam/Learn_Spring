package com.uit.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CommonRepository <T, ID extends Serializable> extends MongoRepository<T, ID> {
}
