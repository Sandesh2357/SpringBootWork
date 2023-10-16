package com.Sandesh.ToDoDemoApp.service;

import com.Sandesh.ToDoDemoApp.model.ToDo;
import com.Sandesh.ToDoDemoApp.repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    ToDoRepo toDoRepo;

    public String addTodos(List<ToDo> myTodos) {
        toDoRepo.getTodoList().addAll(myTodos);
        return "todos added";

    }

    public List<ToDo> getAllTodos() {

        return toDoRepo.getTodoList();
    }

    public ToDo getTodoById(Integer todoId) {
        List<ToDo> list = getAllTodos();
        for(ToDo toDo : list){
            if(toDo.getTodoId().equals(todoId)){
                return toDo;
            }
        }
        return null;
    }

    public List<ToDo> deletAllTodos() {
         getAllTodos().clear();
         return getAllTodos();
    }

    public String deleteTodoById(Integer Id) {
        List<ToDo> list = getAllTodos();
        for (ToDo toDo : list) {
            if (toDo.getTodoId().equals(Id)) {
                list.remove(toDo);
                return "todo deleted";
            }
        }
        return null;
    }


    public void updateUserById(Integer id, ToDo toDo1) {
        List<ToDo> list = getAllTodos();
        for (ToDo toDo : list) {
            if (toDo.getTodoId().equals(id)) {
                toDo.setTodoName(toDo1.getTodoName());
                toDo.setTodoStatus(toDo1.isTodoStatus());

            }
        }
    }
}
