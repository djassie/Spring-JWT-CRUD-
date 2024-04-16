package com.example.auth.controllers;

import com.example.auth.repositories.UserRepository;
import com.example.auth.entities.User;
import com.example.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "userId", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestParam(value = "userId") int userId, @RequestBody User userRequest){
        User user = userRepository.findById(userId).orElseThrow();

        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPassword(userRequest.getPassword());

        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<User>> getUsers(@RequestParam(defaultValue = "0")int page,
                                               @RequestParam(defaultValue = "0")int size){
        Page<User> pageableUser= userService.getPaginatedUser(PageRequest.of(page, size));
        return new ResponseEntity<>(pageableUser, HttpStatus.OK);
    }
}
