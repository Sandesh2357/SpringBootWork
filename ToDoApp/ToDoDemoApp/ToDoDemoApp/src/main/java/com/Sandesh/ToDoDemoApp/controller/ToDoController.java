package com.Sandesh.ToDoDemoApp.controller;


import com.Sandesh.ToDoDemoApp.model.ToDo;
import com.Sandesh.ToDoDemoApp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
     @Autowired
    ToDoService toDoService;

     @PostMapping("Todos")
       public String addTodos(@RequestBody List<ToDo> myTodos){
         toDoService.addTodos(myTodos);
         return myTodos.size() + " todos added";
     }

     @GetMapping("todos")
     public List<ToDo> getAllTodos(){

         return toDoService.getAllTodos();
     }
     @GetMapping("todo/{todoId}")
     public ToDo getTodoById(@PathVariable Integer todoId){

         return toDoService.getTodoById(todoId);
     }
     @DeleteMapping("delete/todos")
     public List<ToDo> deletAll(){
         return toDoService.deletAllTodos();
     }
     @DeleteMapping("delete/todo/{Id}")
     public String deletTodoById(@PathVariable Integer Id){
          return toDoService.deleteTodoById(Id);
     }
     @PutMapping("update/{id}")
    public String updateById(@PathVariable Integer id, @RequestBody ToDo toDo){
       toDoService.updateUserById(id,toDo);
       return "updated";
     }
}
