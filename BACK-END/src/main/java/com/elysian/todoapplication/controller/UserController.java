package com.elysian.todoapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.elysian.todoapplication.entity.User;
import com.elysian.todoapplication.services.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserServices userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> userLogin(@RequestBody User user) {
        User logedUser = userService.verifyUser(user.getUsername(), user.getPassword());

        return logedUser!=null? new ResponseEntity<>(logedUser,HttpStatus.OK) :  new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> userRegister(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        System.out.println(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
//        return newUser!=null? new ResponseEntity<>(newUser,HttpStatus.OK) :  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAll() {
        List<User> user  = userService.getAllUsers();
        return new ResponseEntity<>(user,HttpStatus.OK) ;
    }



}