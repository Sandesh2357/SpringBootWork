package com.sandesh.InstagramBasicDesign.service;

import com.sandesh.InstagramBasicDesign.model.AuthenticationToken;
import com.sandesh.InstagramBasicDesign.model.User;
import com.sandesh.InstagramBasicDesign.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    AuthenticationService authenticationService;


    public String userSignUp(User newUser) {
        String newEmail = newUser.getEmail();
        User existingUser = userRepo.findFirstByEmail(newEmail);
        if (existingUser != null) {
            return "Email already in use!!!";
        }
        String signUpPassword = newUser.getPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt((signUpPassword));

            newUser.setPassword(encryptedPassword);
            userRepo.save(newUser);
            return "user registered";
        } catch (NoSuchAlgorithmException e) {
            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String userSginIn(String email, String password) {
        User existingUser = userRepo.findFirstByEmail(email);
        if (existingUser == null) {
            return "not a valid email, please signUp first!!!";
        }
        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);
            if (existingUser.getPassword().equals(encryptedPassword)) {
                AuthenticationToken token = new AuthenticationToken();
                if (EmailHandler.sendEmail(email, "otp after login", token.getToken())) {
                    authenticationService.createToken(token);
                    return "check email for otp/token!!!";
                } else {
                    return "error while generating token";
                }
            } else {
                return "invalid credential";
            }
        } catch (NoSuchAlgorithmException e) {
            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public User updateUserbyUserId(Long userId, User user) {
        User existingUser = userRepo.findByUserId(userId);
        if(existingUser != null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setAge(user.getAge());
            existingUser.setPassword(user.getPassword());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            return userRepo.save(existingUser);
        }
        else {
            return null;
        }
    }
}
