package com.example.springbootcrudcaching.repository;

import com.example.springbootcrudcaching.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
