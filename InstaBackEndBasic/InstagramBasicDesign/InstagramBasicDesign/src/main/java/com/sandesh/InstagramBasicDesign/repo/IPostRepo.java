package com.sandesh.InstagramBasicDesign.repo;

import com.sandesh.InstagramBasicDesign.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface IPostRepo extends CrudRepository<Post,Integer> {
    Post findBypostId(Integer id);
}
