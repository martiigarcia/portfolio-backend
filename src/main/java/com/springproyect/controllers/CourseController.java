package com.springproyect.controllers;

import com.springproyect.apiService.ICourseService;
import com.springproyect.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @PostMapping("/save")
    public Map<String, Object> saveCourse(@RequestBody Course course) {
        Map<String, Object> map = new HashMap<>();
        try {
            iCourseService.saveCourse(course);
            map.put("result", "success");
            map.put("message", "El proyecto se guardo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }

        return map;
    }

    @GetMapping("/list")
    public Map<String, Object> getCourses() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Course> courseList = iCourseService.getCourses();
            map.put("courses", courseList);
            map.put("result", "success");
            map.put("message", "La operacion se realizo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @GetMapping("/find/{id}")
    public Map<String, Object> findCourse(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        try {

            Course course = iCourseService.findCourse(id);
            if (course != null) {
                map.put("course", course);
                map.put("result", "success");
                map.put("message", "La operacion se realizo con exito");
            } else {
                map.put("result", "error");
                map.put("message", "Algo salio mal... No existe el curso solicitado");
            }
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> updateCourse(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("description") String description
    ) {
        Map<String, Object> map = new HashMap<>();
        try {

            Course course = iCourseService.findCourse(id);
            if (course != null) {

                course.setName(name);
                course.setDescription(description);

                iCourseService.saveCourse(course);
                map.put("result", "success");
                map.put("message", "La informacion del curso se modifico con exito");

            } else {
                map.put("result", "error");
                map.put("message", "Algo salio mal... No existe el curso solicitado");
            }
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;

    }
}
