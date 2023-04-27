package org.genspark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
//        tight coupling
//        Car obj = new Car();
//        obj.drive();
//
//        Bike obj2 = new Bike();
//        obj2.drive();
//
//        Using an interface
//        Vehicle obj = new Bike();
//        obj.drive();

        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        Vehicle obj = (Vehicle) context.getBean("Vehicle");
        obj.drive();
//        Tire obj = (Tire) context.getBean("Tire");
//        System.out.println(obj);

    }
}