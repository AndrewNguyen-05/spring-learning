package com.luv2code.springhibernate;

import com.luv2code.springhibernate.dao.StudentDAO;
import com.luv2code.springhibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner (StudentDAO studentDAO){

        return runner -> {
            createMultipleStudent(studentDAO);
            //createStudent(studentDAO);
        };
    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        Student student1 = new Student("Andrew", "Nguyen", "andrewnguyen@gmail.com");
        Student student2 = new Student("Beta", "Minh", "betaminh@gmail.com");
        Student student3 = new Student("Dennis", "Dang", "dennisdang@gmail.com");
        Student student4 = new Student("Charlie", "James", "charliejames@gmail.com");
        Student student5 = new Student("Chad", "Darby", "chaddarbyn@gmail.com");

        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
        studentDAO.save(student4);
        studentDAO.save(student5);
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        int numRow = studentDAO.deleteAll();
        System.out.println("Number of rows deleted: " + numRow);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int id = 7;
        studentDAO.delete(id);

    }

    private void updateStudent(StudentDAO studentDAO) {
        int id = 1;
        Student theStudent = studentDAO.findById(id);
        theStudent.setLastName("Tran");

        studentDAO.update(theStudent);
        System.out.println("Update student: " + theStudent);
    }

    private void findStudentByLastName(StudentDAO studentDAO) {
        List<Student> result = studentDAO.findByLastName("Nguyen");
        for(Student student : result){
            System.out.println(student);
        }
    }

    private void findAllStudent(StudentDAO studentDAO){
        List<Student> allStudent = studentDAO.findAll();

        for(Student student : allStudent){
            System.out.println(student);
        }
    }

    private void findStudentById(StudentDAO studentDAO) {
        Student tempStudent = new Student("James", "Charles", "jc@gmail.com");
        studentDAO.save(tempStudent);
        Student secondStudent = studentDAO.findById(tempStudent.getId());
        System.out.println("the student: " + secondStudent);
    }

    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student...");
        Student tempStudent = new Student("Andrew", "Nguyen", "andrewnguyen@gmail.com");

        //save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        //display id
        System.out.println("Saved student. Generated id: " + tempStudent.getId());

    }

}
