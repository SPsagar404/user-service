package com.ms.userservice.service;

import com.ms.userservice.entity.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUsers();

    public User getUserById(Long userId);


}
