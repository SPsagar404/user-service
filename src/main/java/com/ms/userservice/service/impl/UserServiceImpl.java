package com.ms.userservice.service.impl;

import com.ms.userservice.entity.User;
import com.ms.userservice.exception.ResourceNotFoundException;
import com.ms.userservice.repository.UserRepository;
import com.ms.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public User saveUser(User user) {

        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        User user = repository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id :: "+userId+" is not foundon server ...."));
        return user;
    }
}
