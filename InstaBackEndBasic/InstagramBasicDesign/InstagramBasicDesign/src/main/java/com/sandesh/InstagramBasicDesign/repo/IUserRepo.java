package com.sandesh.InstagramBasicDesign.repo;

import com.sandesh.InstagramBasicDesign.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepo extends CrudRepository<User,Long> {
    User findFirstByEmail(String newEmail);

    User findByUserId(Long userId);
}
