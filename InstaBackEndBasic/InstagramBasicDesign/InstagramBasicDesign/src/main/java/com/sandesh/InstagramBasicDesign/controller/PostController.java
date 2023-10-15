package com.sandesh.InstagramBasicDesign.controller;

import com.sandesh.InstagramBasicDesign.model.Post;
import com.sandesh.InstagramBasicDesign.model.User;
import com.sandesh.InstagramBasicDesign.service.AuthenticationService;
import com.sandesh.InstagramBasicDesign.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    AuthenticationService authenticationService;

      @PostMapping("/post")
    public  String addPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    @GetMapping("/post")
    public Post getPost(@PathVariable Integer id){
          return postService.getPost(id);
    }

}
