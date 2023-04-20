package com.genspark.SecurityDemo.Service;

import com.genspark.SecurityDemo.Entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;

    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Course(101,"Spring Framework", "Pradeep"));
        list.add(new Course(102,"Spring Boot", "Sulvider"));
        list.add(new Course(103,"Web Application", "Adam"));
    }

    @Override
    public List<Course> getAllCourse() {
        return list;
    }

    @Override
    public Course getCourseByID(int courseID) {
        Course c = null;
        for (Course course:list) {
            if(course.getCourseID()==courseID){
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course){
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        String title = course.getTitle();
        String instructor = course.getInstructor();
        Course c = null;
        for(Course e:list){
            if(e.getCourseID()==course.getCourseID()){
                e.setTitle(title);
                e.setInstructor(instructor);
                c=e;
                break;
            }
        }
        return c;
    }

    @Override
    public String deleteCourseByID(int courseID) {
        for (Course course: list){
            if(course.getCourseID()==courseID){
                list.remove(course);
                break;
            }
        }
        return "Deleted Successfully";
    }


}
