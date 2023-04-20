package com.genspark.SecurityDemo.Entity;

public class Course {


    private int courseID;
    private String title;
    private String instructor;

    public Course(){

    }

    public Course(int courseID, String title, String instructor) {
        this.courseID = courseID;
        this.title = title;
        this.instructor = instructor;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
