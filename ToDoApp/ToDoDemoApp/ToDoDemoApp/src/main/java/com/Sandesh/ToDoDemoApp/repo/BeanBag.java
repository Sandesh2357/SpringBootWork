package com.Sandesh.ToDoDemoApp.repo;

import com.Sandesh.ToDoDemoApp.model.ToDo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanBag {

    @Bean
    List<ToDo> getTodoList(){
        return new ArrayList<>();
    }
}
