package com.Sourav.spring;

import com.Sourav.spring.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Desktop dt = context.getBean(Desktop.class);
        Alien al = context.getBean("alien", Alien.class);

        al.code();
        dt.compile();
    }

}
