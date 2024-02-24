package com.jobapplication.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapplication.tracker.model.User;
import com.jobapplication.tracker.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(String email, String name, String pictureUrl) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPictureUrl(pictureUrl);
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getListUser() {
        return userRepository.findAll();
    }

}
