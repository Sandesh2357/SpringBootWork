package com.Sandesh.UserManagementSystem.controller;

import com.Sandesh.UserManagementSystem.entity.User;
import com.Sandesh.UserManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("Users")
    public List<User> getAllUsers()
    {
       return userService.getAllUser();
    }
     @PostMapping("users")
    public String addUsers(@RequestBody List<User> myUsers){

         return userService.addUsers(myUsers);
    }
    @GetMapping("user/{userId}/")
    public User getUserById(@PathVariable Integer userId){

        return userService.findById(userId);
    }
    @DeleteMapping("delet/users")
     public List<User> removeAllUsers(){
         return userService.removeAllusers();
     }
}
