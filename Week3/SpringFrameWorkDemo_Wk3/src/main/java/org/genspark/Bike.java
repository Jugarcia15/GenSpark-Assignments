package org.genspark;

public class Bike implements Vehicle{
    public Tire ty;

    public Bike(Tire ty) {
        this.ty = ty;
    }

    public void drive(){
        System.out.println("I am riding bike..." + ty);
    }
}
