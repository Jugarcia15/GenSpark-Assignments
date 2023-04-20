package com.genspark.SecurityDemo.Dao;

import com.genspark.SecurityDemo.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {


}
