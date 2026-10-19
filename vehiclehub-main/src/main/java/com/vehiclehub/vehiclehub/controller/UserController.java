package com.vehiclehub.vehiclehub.controller;

import com.vehiclehub.vehiclehub.entity.User;
import org.springframework.web.bind.annotation.*;

import com.vehiclehub.vehiclehub.service.UserService;

@RestController 
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // REGISTER - POST
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // LOGIN - POST
    @PostMapping ("/login")
    public String loginUser(
        @RequestParam String username,
        @RequestParam String password
    ) {
        User user = userService.loginUser(username, password);

        if (user != null) {
            return "Login successful. Welcome " + user.getUsername();
        }

        return "Invalid username or password";
    }
}
