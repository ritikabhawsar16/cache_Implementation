package com.example.springbootcrudcaching.controller;

import com.example.springbootcrudcaching.entity.Student;
import com.example.springbootcrudcaching.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CacheConfig(cacheNames = "students")
@Slf4j
public class StudentController {

     @Autowired
    private  StudentService studentService;

    @GetMapping("/getall")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("GetById/{id}")
    @Cacheable(key = "#id")
    public Student getStudentById(@PathVariable Integer id) {
        log.info("Getting student with id {} from DB", id);
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("UpdateById/{id}")
    @CachePut(key = "#id")
    public Student updateStudent( @RequestBody Student student,@PathVariable Integer id) {
        return studentService.updateStudent(student , id);
    }

    @CacheEvict(key = "#id")
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
       studentService.deleteStudent(id);
       return "Student Deleted Successfully";
    }
}

