package com.sandesh.InstagramBasicDesign.service;

import com.sandesh.InstagramBasicDesign.model.Post;
import com.sandesh.InstagramBasicDesign.repo.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    IPostRepo postRepo;


    public String addPost(Post post) {
        postRepo.save(post);
        return "post added!!!";
    }


    public Post getPost(Integer id) {
        return postRepo.findBypostId(id);
    }
}
