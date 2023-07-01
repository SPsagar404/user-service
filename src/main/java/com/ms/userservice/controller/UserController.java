package com.ms.userservice.controller;


import com.ms.userservice.entity.User;
import com.ms.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-service/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/user")
    public ResponseEntity<User> createUserAcount(@RequestBody User user){
        return  new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserBtyId(@PathVariable Long userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllusers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}