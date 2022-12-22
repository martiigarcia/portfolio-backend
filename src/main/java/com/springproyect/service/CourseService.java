package com.springproyect.service;

import com.springproyect.apiService.ICourseService;
import com.springproyect.model.Course;
import com.springproyect.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void addCourse() {

    }

    @Override
    public Course findCourse(Long id) {
        return null;
    }

    @Override
    public List<Course> getCourses() {
        return null;
    }


}
