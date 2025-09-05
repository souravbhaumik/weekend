package com.Sourav.spring.config;

import com.Sourav.spring.Alien;
import com.Sourav.spring.Desktop;
import com.Sourav.spring.Laptop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.Sourav.spring")
public class AppConfig {

//    @Bean
//    public Alien alien() {
//        Alien alien = new Alien("Tinni", "Female");
//        alien.setLaptop(laptop());
//        return alien;
//    }
//
//
//    @Bean(name = "com2")
//    @Scope("prototype")
//    public Desktop desktop() {
//        return new Desktop();
//    }
//
//    Laptop laptop() {
//        return new Laptop();
//    }

}
