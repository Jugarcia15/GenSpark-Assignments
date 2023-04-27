package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;

public class Car implements Vehicle {

    //@Autowired
    public Tire ty;

//    public Tire getTy() {
//        return ty;
//    }
//
//    public void setTy(Tire ty) {
//        this.ty = ty;
//    }


    public Car(Tire ty) {
        this.ty = ty;
    }

    public void drive(){
        System.out.println("I am driving car..." + ty);
    }
}
