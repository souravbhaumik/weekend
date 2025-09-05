package com.Sourav.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "config.xml");
        Alien obj = (Alien)context.getBean("alien");
        obj.code();
        System.out.println( obj.getAge() );
        System.out.println(obj.gender);
        System.out.println(obj.name);
    }
}
