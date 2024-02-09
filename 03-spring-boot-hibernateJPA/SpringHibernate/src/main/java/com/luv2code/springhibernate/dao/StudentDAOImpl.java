package com.luv2code.springhibernate.dao;

import com.luv2code.springhibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //define Entity Manager field
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //define save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    //define find student method
    @Override
    public Student findById(int id){
        return entityManager.find(Student.class, id);
    }

    //define find all student method
    @Override
    public List<Student> findAll(){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    //define find student by last name
    @Override
    public List<Student> findByLastName(String lastName){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:lastName", Student.class);
        theQuery.setParameter("lastName", lastName);
        return theQuery.getResultList();
    }

    //define update student method
    @Override
    @Transactional
    public void update(Student theStudent){
        entityManager.merge(theStudent);
    }

    //define delete method
    @Override
    @Transactional
    public void delete(int id){
        Student deleteStudent = entityManager.find(Student.class, id);
        entityManager.remove(deleteStudent);
    }

    //define delete by lastName method
    @Override
    @Transactional
    public int deleteAll(){
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
