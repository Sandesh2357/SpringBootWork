package com.sandesh.UrlHitCounter;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlHitService {
    private Map<String,Integer> userHitCounts = new HashMap<>();

    public void increamentUserHitCounts(String userName){
        userHitCounts.put(userName,userHitCounts.getOrDefault(userName,0) +1);
    }
    public Map<String, Integer> getUserHitCount(String userName) {
      Map<String,Integer> result = new HashMap<>();
      result.put(userName,userHitCounts.getOrDefault(userName,0));
      return result;

    }
}
