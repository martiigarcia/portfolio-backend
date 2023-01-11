package com.springproyect.controllers;

import com.springproyect.apiService.IUserService;
import com.springproyect.model.Proyect;
import com.springproyect.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public Map<String, Object> getUsers() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<User> userList = iUserService.getUsers();
            map.put("users", userList);
            map.put("result", "success");
            map.put("message", "La operacion se realizo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> saveUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            iUserService.saveUser(user);
            map.put("result", "success");
            map.put("message", "El usuario se guardo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteUser(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            iUserService.deleteUser(id);
            map.put("result", "success");
            map.put("message", "El usuario se elimino con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @GetMapping("/find/{id}")
    public Map<String, Object> findUser(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            User user = iUserService.findUser(id);
            if (user != null) {
                map.put("user", user);
                map.put("result", "success");
                map.put("message", "La operacion se realizo con exito");
            } else {
                map.put("result", "error");
                map.put("message", "Algo salio mal... No existe el usuario solicitado");
            }
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> updateUser(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("age") int age,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("information") String information,
            @RequestParam("admin") boolean admin
    ) {
        Map<String, Object> map = new HashMap<>();
        try {

            User user = iUserService.findUser(id);
            if (user != null) {

                user.setName(name);
                user.setSurname(surname);
                user.setAge(age);
                user.setEmail(email);
                user.setPassword(password);
                user.setInformation(information);
                user.setIsAdmin(admin);

                iUserService.saveUser(user);

                map.put("result", "success");
                map.put("message", "La informacion del usuario se modifico con exito");

            } else {
                map.put("result", "error");
                map.put("message", "Algo salio mal... No existe el usuario solicitado");
            }
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;

    }

//    @PutMapping("/addProyect/{id}")
//    public Map<String, Object> addProyect(
//            @PathVariable Long id,
//            @RequestBody Proyect project
//    ) {
//        Map<String, Object> map = new HashMap<>();
//        try {
//            User user = iUserService.findUser(id);
//
//            if (user != null) {
//                if (user.containsProject(project.getId())) {
//                    map.put("result", "success");
//                    map.put("message", "El proyecto ya se encuentra en la lista del usuario");
//                } else {
//                    user.addProjectToList(project);
//                    iUserService.saveUser(user);
//                    map.put("result", "success");
//                    map.put("message", "El proyecto se agrego a la lista de proyectos del usuario con exito");
//                }
//            } else {
//                map.put("result", "error");
//                map.put("message", "Algo salio mal... No existe el usuario solicitado");
//            }
//        } catch (Exception e) {
//            map.put("result", "error");
//            map.put("message", "Algo salio mal... " + e.getMessage());
//        }
//        return map;
//    }
//
//    @PutMapping("/vaciar/{id}")
//    public Map<String, Object> clearProjectList(@PathVariable Long id) {
//        Map<String, Object> map = new HashMap<>();
//        User user = iUserService.findUser(id);
//        user.setProjectList(null);
//        iUserService.saveUser(user);
//        map.put("result", "success");
//        map.put("message", "La lista se vacio");
//        map.put("proyectos", user.getProjectList());
//        return map;
//    }
//
//    @PutMapping("/deleteProyect/{id}")
//    public Map<String, Object> deleteProyectFromList(
//            @PathVariable Long id,
//            @RequestBody Proyect project
//    ) {
//        Map<String, Object> map = new HashMap<>();
//        User user = iUserService.findUser(id);
//        try {
//            user.removeProject(project.getId());
//            iUserService.saveUser(user);
//
//            map.put("result", "success");
//            map.put("message", "Las listas se vaciaron");
//            map.put("proyectos", user.getProjectList());
//
//        } catch (Exception e) {
//            map.put("result", "error");
//            map.put("message", "Algo salio mal... " + e.getMessage());
//        }
//
//        return map;
//    }
//
//    @PutMapping("/addCourse/{id}")
//    public Map<String, Object> addCourse(
//            @PathVariable Long id,
//            @RequestBody Course course
//    ) {
//        Map<String, Object> map = new HashMap<>();
//        try {
//            User user = iUserService.findUser(id);
//            if (user != null) {
//                if (user.containsCourse(course.getId())) {
//                    map.put("result", "success");
//                    map.put("message", "El curso ya se encuentra en la lista del usuario");
//                } else {
//                    user.addCourseToList(course);
//                    iUserService.saveUser(user);
//                    map.put("result", "success");
//                    map.put("message", "El curso se agrego a la lista de cursos del usuario con exito");
//                }
//            } else {
//                map.put("result", "error");
//                map.put("message", "Algo salio mal... No existe el usuario solicitado");
//            }
//        } catch (Exception e) {
//            map.put("result", "error");
//            map.put("message", "Algo salio mal... " + e.getMessage());
//        }
//        return map;
//    }
//    @PutMapping("/deleteCourse/{id}")
//    public Map<String, Object> deleteCourseFromList(
//            @PathVariable Long id,
//            @RequestBody Course course
//    ) {
//        Map<String, Object> map = new HashMap<>();
//        User user = iUserService.findUser(id);
//        try {
//            user.removeCourse(id);
//            iUserService.saveUser(user);
//
//            map.put("result", "success");
//            map.put("message", "Las listas se vaciaron");
//            map.put("cursos", user.getCourseList());
//
//        } catch (Exception e) {
//            map.put("result", "error");
//            map.put("message", "Algo salio mal... " + e.getMessage());
//        }
//        return map;
//    }

}
