package com.sourav.spring.test;

import com.sourav.spring.test.model.Student;
import com.sourav.spring.test.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class  TestApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(TestApplication.class);

        Student s1 = context.getBean(Student.class);
        s1.setRollNumber(9);
        s1.setName("Tinni");
        s1.setGender("Female");
        s1.setAge(27);
        s1.setMarks(900);

        StudentService studentService =
                context.getBean(
                        "studentService", StudentService.class);
        studentService.addStudent(s1);
        List<Student> students =
                studentService.getStudents();
        System.out.println(students);
    }

}
