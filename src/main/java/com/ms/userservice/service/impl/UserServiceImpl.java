package com.ms.userservice.service.impl;

import com.ms.userservice.client.IHotelServiceRestConsumer;
import com.ms.userservice.client.IRatingServiceRestConsumer;
import com.ms.userservice.entity.Rating;
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

    @Autowired
    private IRatingServiceRestConsumer ratingClient;

    @Autowired
    private IHotelServiceRestConsumer hotelClient;



    @Override
    public User saveUser(User user) {

        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> all = repository.findAll();
        for (User user:all) {
            List<Rating> ratings = ratingClient.ratingsByUserId(user.getUserId()).getBody();
            for (Rating rating:ratings) {
                rating.setHotel(hotelClient.gethotelByHotelId(rating.getHotelId()).getBody());
            }
            user.setRating(ratings);
        }
        return all;
    }

    @Override
    public User getUserById(Long userId) {
        User user = repository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id :: "+userId+" is not found on server ...."));
        List<Rating> ratings = ratingClient.ratingsByUserId(userId).getBody();
        for (Rating rating:ratings) {
            rating.setHotel(hotelClient.gethotelByHotelId(rating.getHotelId()).getBody());
        }
        user.setRating(ratings);

        return user;
    }
}
