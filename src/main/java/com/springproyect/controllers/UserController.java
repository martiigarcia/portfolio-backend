package com.springproyect.controllers;

import com.springproyect.apiService.IUserService;
import com.springproyect.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public String getUsers() {
        System.out.println("LIST");
        System.out.println(iUserService.getUsers());
        return "LIST";
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        System.out.println("SAVE");
        iUserService.saveUser(user);
        return "SAVE";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        System.out.println("DELETE");
        iUserService.deleteUser(id);
        return "DELETE";
    }

    @GetMapping("/find/{id}")
    public String findUser(@PathVariable Long id) {
        System.out.println("FIND");
        User user = iUserService.findUser(id);
        return user.getName() + " " + user.getSurname() + " " + user.getId();
//        return "FIND";
    }

    @PutMapping("/update/{id}")
    public String updateUser(
            @PathVariable Long id,
            @RequestParam("nombre") String name,
            @RequestParam("apellido") String surname,
            @RequestParam("edad") int age,
            @RequestParam("email") String email,
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        System.out.println("UPDATE");
        User user = iUserService.findUser(id);

        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        iUserService.saveUser(user);

        return "USER UPDATED";
    }
}
