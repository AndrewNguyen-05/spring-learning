package com.luv2code.springhibernate.dao;

import com.luv2code.springhibernate.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save (Student theStudent);
    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update (Student theStudent);

    void delete (int id);

    int deleteAll ();
}
