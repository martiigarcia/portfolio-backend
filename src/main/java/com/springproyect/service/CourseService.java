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
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course findCourse(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        return course;
    }

    @Override
    public List<Course> getCourses() {
        List<Course> courseList = courseRepository.findAll();
        return courseList;
    }


}
