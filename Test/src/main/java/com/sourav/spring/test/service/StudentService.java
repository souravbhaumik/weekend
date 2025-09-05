package com.sourav.spring.test.service;

import com.sourav.spring.test.model.Student;
import com.sourav.spring.test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List getStudents() {
        return studentRepository.findAll();
    }

}
