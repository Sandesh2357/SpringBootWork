package com.sandesh.UniversityEventManagement.service;

import com.sandesh.UniversityEventManagement.model.DepartmentType;
import com.sandesh.UniversityEventManagement.model.Student;
import com.sandesh.UniversityEventManagement.repository.IStudent;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudent iStudent;


    public String addStudent(@Valid @RequestBody Student student) {
        iStudent.save(student);
        return "Student added!!!";
    }

    public String updateStudentDepartment(Long id, DepartmentType departmentType) {
        Student existingStudent = iStudent.findById(id).orElse(null);
        existingStudent.setDepartmentType(departmentType);
        iStudent.save(existingStudent);
        return "dDepartment updated!!!";
    }

    public String removeStudentById(Long id) {
        if (iStudent.existsById(id)) {
            iStudent.deleteById(id);
            return "student removed!!!";
        } else {
            return "student not found";
        }
    }

    public List<Student> getAllStudent() {
        return (List<Student>) iStudent.findAll();
    }

    public Student getStudentById(Long id) {
        return iStudent.findById(id).orElse(null);
    }
}
