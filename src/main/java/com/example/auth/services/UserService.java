package com.example.auth.services;

import com.example.auth.entities.User;
import com.example.auth.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> getPaginatedUser(Pageable page){
     return userRepository.findAll(page);
    }
}
