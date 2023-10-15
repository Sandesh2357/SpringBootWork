package com.sandesh.InstagramBasicDesign.service;

import com.sandesh.InstagramBasicDesign.model.AuthenticationToken;
import com.sandesh.InstagramBasicDesign.repo.AuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    AuthenticationRepo authenticationRepo;

    public void createToken(AuthenticationToken token) {
        authenticationRepo.save(token);
    }
    public boolean authenticate(String email,String token){
        AuthenticationToken Token = authenticationRepo.findFirstByToken(token);
        if(token!=null){
            return Token.getUser().getEmail().equals(email);
        }
        else{
            return false;
        }
    }
    public void deleteToken(String token) {
        AuthenticationToken Token =  authenticationRepo.findFirstByToken(token);
        authenticationRepo.delete(Token);
    }
}
