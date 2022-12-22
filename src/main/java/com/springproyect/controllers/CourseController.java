package com.springproyect.controllers;

import com.springproyect.apiService.ICourseService;
import com.springproyect.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @GetMapping("/list")
    public String getCourses() {
        return "GET ALL";
    }

    @GetMapping("/find/{id}")
    public String findCourse(@PathVariable Long id) {
        return "FIND";
    }

    @GetMapping("/update/{id}")
    public void updateCourse(
            @PathVariable Long id,
            @RequestParam("nombre") String name,
            @RequestParam("descripcion") String description,
            @RequestParam("fechaInicio") Date begging,
            @RequestParam("fechaFin") Date ending
    ) {
        //editar
    }
}
