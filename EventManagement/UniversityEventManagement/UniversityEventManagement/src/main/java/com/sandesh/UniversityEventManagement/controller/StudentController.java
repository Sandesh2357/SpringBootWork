package com.sandesh.UniversityEventManagement.controller;

import com.sandesh.UniversityEventManagement.model.DepartmentType;
import com.sandesh.UniversityEventManagement.model.Student;
import com.sandesh.UniversityEventManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("student")
    public String addStudent(@Valid @RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("student/id/{id}")
    public String updateStudentDepartment(@PathVariable Long id, @RequestParam DepartmentType departmentType){
        return studentService.updateStudentDepartment(id,departmentType);
    }
    @DeleteMapping("student/id/{id}")
    public String removeStudentById(@PathVariable Long id){
      return studentService.removeStudentById(id);
    }
    @GetMapping("student")
    public List<Student> getAllStudent(){
       return studentService.getAllStudent();
    }
    @GetMapping("student/id/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}
