package com.genspark.SecurityDemo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_courses")
public class Course {

    @Id
    @Column(name="c_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseID;

    private String title;
    private String instructor;

    public Course(){

    }

    public Course(String title, String instructor) {
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
