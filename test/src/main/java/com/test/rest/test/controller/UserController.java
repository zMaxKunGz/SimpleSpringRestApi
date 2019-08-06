package com.test.rest.test.controller;

import java.util.Map;

import com.test.rest.test.model.User;
import com.test.rest.test.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/user/{name}") 
    public @ResponseBody Iterable<User> findUserByName(@PathVariable("name") String name) {
        return userRepository.findByName(name);
    }

    @GetMapping(path = "/user/") 
    public @ResponseBody Iterable<User> findAllUser() {
        return userRepository.findAll();
    }

    @PostMapping(path = "/user")
    public @ResponseBody String insertUser(@RequestParam Map<String, String> body) {
        User user = new User(body.get("name"), body.get("email"));
        userRepository.save(user);
        return "Success";
    }
}