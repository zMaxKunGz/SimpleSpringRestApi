package com.test.rest.test.repository;

import java.util.List;

import com.test.rest.test.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByName(String name);
}