package org.genspark;

import org.springframework.stereotype.Component;

public class Phone {

    private String mobileNum;

    public Phone(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    //    public String getMobileNum() {
//        return mobileNum;
//    }
//
//    public void setMobileNum(String mobileNum) {
//        this.mobileNum = mobileNum;
//    }

    @Override
    public String toString(){
        return "Phone{" + "mobile='" + mobileNum + '\'' + '}';
    }
}
