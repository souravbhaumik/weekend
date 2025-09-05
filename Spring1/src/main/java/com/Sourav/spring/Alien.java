package com.Sourav.spring;

import org.springframework.stereotype.Component;

@Component
public class Alien {

    int age=0;

    String name;
    String gender;

    Laptop laptop;

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Alien(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void code() {
        laptop.compile();
    }

}
