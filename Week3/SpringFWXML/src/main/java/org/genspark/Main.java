package org.genspark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
//        Vehicle obj = (Vehicle) context.getBean("Vehicle");
//        Tire obj = (Tire) context.getBean("Tire");
        Student obj = (Student) context.getBean("Student");
        obj.details();
//        obj.drive();
        System.out.println(obj);
//        System.out.println(obj);

    }
}