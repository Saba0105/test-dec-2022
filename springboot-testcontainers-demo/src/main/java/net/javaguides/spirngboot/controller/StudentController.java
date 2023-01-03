package net.javaguides.spirngboot.controller;

import net.javaguides.spirngboot.entity.Student;
import net.javaguides.spirngboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    
    @RequestMapping("/")  
    public String hello()   
    {  
    return "Hello World";  
    } 

    @PostMapping
    @RequestMapping("/api/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping
    @RequestMapping("/api/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
