package com.fibi.fibi.Controller;


import com.fibi.fibi.Constants.*;
import com.fibi.fibi.model.User;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.StreamSupport;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Constants.API_PATH + UserController.USERS_PATH)
public class UserController {

    @Autowired
    UserRepository userRepository;

    public static final String USERS_PATH = "/users";

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public User createUser(@Valid @RequestBody User user) {
        user.setPassword(Hashing.sha256().hashString(user.getPassword(), StandardCharsets.UTF_8).toString());
        user.setKoins(20L);
        user.setReputation(5);
        return userRepository.save(user);
    }

    @GetMapping
    @RequestMapping("/login")
    public User login(@Valid @RequestBody Map<String, String> values) {
        List<User> users = userRepository.findAll();
        String password = values.get("password");
        Optional<User> loginUser = StreamSupport.stream(users.spliterator(), false).filter(u -> u.getUsername().equals(values.get("username"))).findFirst();
        if(loginUser.isPresent() && loginUser.get().getPassword().equals(Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString())) {
            return loginUser.get();
        }
        else return null;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") long userId) {
        return userRepository.findById(userId).get();
    }

    /*
    @PutMapping
    @RequestMapping(Constants.API_PATH + USERS_PATH + "/{id}")
    public User updateUserById(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {
        User user = userRepository.findById(userId).get();
        user.setEmail(userDetails.getEmail());
        user.setEmail(userDetails.getUsername());
        return userRepository.save(user);
    }
    */
}
