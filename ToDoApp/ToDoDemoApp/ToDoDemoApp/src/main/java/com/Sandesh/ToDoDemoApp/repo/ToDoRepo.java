package com.Sandesh.ToDoDemoApp.repo;

import com.Sandesh.ToDoDemoApp.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToDoRepo {

    @Autowired
    private List<ToDo> TodoList;

    public List<ToDo> getTodoList() {
        return TodoList;
    }
}
