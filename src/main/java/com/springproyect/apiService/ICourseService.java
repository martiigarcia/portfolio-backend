package com.springproyect.apiService;

import com.springproyect.model.Course;
import com.springproyect.model.Project;

import java.util.List;

public interface ICourseService {
    
    public void addCourse();

    public Course findCourse(Long id);

    public List<Course> getCourses();

//    public List<Course> getCoursesByUser(Long id_user);

}
