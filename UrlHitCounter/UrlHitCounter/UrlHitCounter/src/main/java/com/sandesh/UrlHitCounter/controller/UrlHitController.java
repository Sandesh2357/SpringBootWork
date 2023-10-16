package com.sandesh.UrlHitCounter.controller;

import com.sandesh.UrlHitCounter.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UrlHitController {
    @Autowired
    UrlHitService urlHitService;

    @GetMapping("visitor-count-app/username/{userName}/count")
    public Map<String,Integer> getUrlHitCount(@PathVariable String userName){
        return urlHitService.getUserHitCount(userName);
    }
}
