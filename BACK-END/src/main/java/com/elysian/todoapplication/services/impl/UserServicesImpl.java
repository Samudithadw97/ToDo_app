package com.elysian.todoapplication.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysian.todoapplication.entity.User;
import com.elysian.todoapplication.repository.UserRepository;
import com.elysian.todoapplication.services.UserServices;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Pattern;

import com.google.common.hash.Hashing;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserRepository userRepositories;

    @Override
    public User verifyUser(String username, String password) {
        User user = userRepositories.findByUsername(username);
        //match password 8 characters and atleast one character and number
        boolean match =Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d\\w\\W]{8,}$",password);
        System.out.println(match);
        String pass = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        return pass.equals(user.getPassword()) && match ? user : null;
    }

    @Override
    public User registerUser(User user) {
        boolean match =Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d\\w\\W]{8,}$",user.getPassword());

        if(match){
            String pass = Hashing.sha256()
                    .hashString(user.getPassword(), StandardCharsets.UTF_8)
                    .toString();
            user.setPassword(pass);
            user.setType("user");
            System.out.println(user);
            User newusr = userRepositories.save(user);
            return newusr;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositories.findAll();
    }
}
