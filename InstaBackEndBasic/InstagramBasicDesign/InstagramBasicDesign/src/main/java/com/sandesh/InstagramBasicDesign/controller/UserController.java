package com.sandesh.InstagramBasicDesign.controller;

import com.sandesh.InstagramBasicDesign.model.User;
import com.sandesh.InstagramBasicDesign.service.AuthenticationService;
import com.sandesh.InstagramBasicDesign.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public String userSignUp(@Valid @RequestBody User newUser){
        return userService.userSignUp(newUser);
    }

    @PostMapping("/signIn/{email}")
    public String userSginIn(@PathVariable String email,@PathVariable String password){
        return userService.userSginIn(email,password);
    }
    public User updateUserByUserId(@PathVariable Long userId,@RequestBody User user){
        return userService.updateUserbyUserId(userId,user);
    }

}
