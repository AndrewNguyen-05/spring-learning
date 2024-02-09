package com.luv2code.springrestdemo.rest;

import com.luv2code.springrestdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Andrew", "Nguyen"));
        theStudents.add(new Student("Beta", "Minh"));
        theStudents.add(new Student("Thang", "Nguyen"));
        theStudents.add(new Student("James", "Charles"));
        theStudents.add(new Student("Nguyen", "Minh"));
    }
    @GetMapping("/students")
    public List<Student> getTheStudents(){
        return this.theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Can't found student with id " + studentId);
        }

        return this.theStudents.get(studentId);
    }

}
