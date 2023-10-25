package com.sandesh.UniversityEventManagement.repository;

import com.sandesh.UniversityEventManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudent extends JpaRepository<Student,Long> {
}
