package org.genspark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //AbstractApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(demoConfig.class);
//        Vehicle obj = (Vehicle) context.getBean("Vehicle");
//        Tire obj = (Tire) context.getBean("Tire");
        Student obj = (Student) context.getBean(Student.class);
        obj.displayDetails();
//        obj.drive();
        System.out.println(obj);
//        System.out.println(obj);

    }
}