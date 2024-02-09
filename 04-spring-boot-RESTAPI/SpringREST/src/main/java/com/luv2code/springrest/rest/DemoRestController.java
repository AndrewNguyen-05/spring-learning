package com.luv2code.springrest.rest;

import com.luv2code.springrest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Andrew", "Nguyen"));
        theStudents.add(new Student("Beta", "Minh"));
        theStudents.add(new Student("Thang", "Nguyen"));
    }

    // define endpoint for /students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint for /students/{studentId}
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if ((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }


}
