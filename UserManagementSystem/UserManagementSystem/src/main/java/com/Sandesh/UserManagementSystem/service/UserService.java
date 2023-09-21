package com.Sandesh.UserManagementSystem.service;


import com.Sandesh.UserManagementSystem.entity.User;
import com.Sandesh.UserManagementSystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public List<User> getAllUser() {

        return userRepo.getUserList();
    }

    public String addUsers(List<User> myUsers) {
        getAllUser().addAll(myUsers);
        return myUsers.size() + "users added";
    }

    public User findById(Integer userId) {

       List<User> list = getAllUser();

       for(User user : list){
           if(user.getUserId().equals(userId)){
               return user;
           }
       }
       return null;

    }

    public List<User> removeAllusers() {
        List<User> list = getAllUser();
         getAllUser().clear();
         return list;
    }
}
