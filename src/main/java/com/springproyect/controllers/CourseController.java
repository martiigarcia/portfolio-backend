package com.springproyect.controllers;

import com.springproyect.apiService.ICourseService;
import com.springproyect.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @PostMapping("/save")
    public void saveCourse(@RequestBody Course course) {
        iCourseService.saveCourse(course);
    }

    @GetMapping("/list")
    public  List<Course> getCourses() {
        List<Course> courseList = iCourseService.getCourses();
        return courseList;
    }

    @GetMapping("/find/{id}")
    public Course findCourse(@PathVariable Long id) {
        Course course = iCourseService.findCourse(id);
        return course;
    }

    @PutMapping("/update/{id}")
    public void updateCourse(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("description") String description
    ) {
        //editar
        Course course = iCourseService.findCourse(id);

        course.setName(name);
        course.setDescription(description);

        iCourseService.saveCourse(course);

    }
}
