package com.Sourav.spring.starter;

import jakarta.persistence.*;

@Entity(name="students")
//@Table(name="student")
public class Student {

    @Id
    private int rollNo;

    @Column(name="name")
    private String name;

    private int age;

    @Transient
    private int grade;


    public int getRollNo()
    {
        return rollNo;
    }
    public void setRollNo( int rollNo )
    {
        this.rollNo = rollNo;
    }
    public String getName()
    {
        return name;
    }
    public void setName( String name )
    {
        this.name = name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge( int age )
    {
        this.age = age;
    }


    public String toString() {
        return "Student{rollNo=" + rollNo + ", name=" + name + ", age=" + age + "}";
    }
    

}
