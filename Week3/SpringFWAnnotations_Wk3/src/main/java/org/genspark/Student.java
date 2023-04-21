package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class Student {
    private int id;
    private String name;

    @Autowired
    private List<Phone> phoneNum;

    @Autowired
    private Address addy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(List<Phone> phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Address getAddy() {
        return addy;
    }

    public void setAddy(Address addy) {
        this.addy = addy;
    }

    public Student() {
    }

    public Student(int id, String name, List<Phone> phoneNum, Address addy) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.addy = addy;
    }

    @Override
    public String toString(){
        String str = "Student{" + "id=" + id + ", name='" + name + '\''+ ", ph=";

        Iterator<Phone> iter = phoneNum.iterator();
        while(iter.hasNext()){
            str = str + iter.next() + ",";
        }
        str = str + " ad=" + addy + '}';
        return str;
    }

    public void details(){
        System.out.println("This be a student");
    }

}
