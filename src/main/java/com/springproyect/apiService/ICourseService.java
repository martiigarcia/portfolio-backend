package com.springproyect.apiService;

import com.springproyect.model.Course;
import com.springproyect.model.Project;

import java.util.List;

public interface ICourseService {
    
    public void saveCourse(Course course);

    public Course findCourse(Long id);

    public List<Course> getCourses();


}
