package com.sandesh.InstagramBasicDesign.repo;

import com.sandesh.InstagramBasicDesign.model.AuthenticationToken;
import org.springframework.data.repository.CrudRepository;

public interface AuthenticationRepo extends CrudRepository<AuthenticationToken,Integer> {


    AuthenticationToken findFirstByToken(String token);
}
