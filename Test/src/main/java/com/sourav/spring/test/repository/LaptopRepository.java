package com.sourav.spring.test.repository;

import com.sourav.spring.test.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {

    public void save(Laptop lappy){
        System.out.println("Saved in DB");
    };

}
