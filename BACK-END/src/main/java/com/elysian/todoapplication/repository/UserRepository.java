package com.elysian.todoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elysian.todoapplication.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

}