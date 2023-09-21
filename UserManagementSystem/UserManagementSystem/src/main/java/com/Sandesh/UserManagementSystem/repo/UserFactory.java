package com.Sandesh.UserManagementSystem.repo;

import com.Sandesh.UserManagementSystem.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class UserFactory {

    @Bean
    List<User> getUserListINit(){

        return new ArrayList<>();
    }
}
