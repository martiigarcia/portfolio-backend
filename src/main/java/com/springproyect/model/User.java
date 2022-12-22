package com.springproyect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private int age;
    private boolean isAdmin;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private List<Project> projectList;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private List<Course> courseList;


    protected User() {

    }

    public User(String username, String password, String name, String surname, String email, int age, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.isAdmin = isAdmin;
    }

    public User(String username, String password, String name, String surname, String email, int age, boolean isAdmin, Long id) {
        this(username, password, name, surname, email, age, isAdmin);
        this.id = id;
    }

    public User(String username, String password, String name, String surname, String email, int age, boolean isAdmin, List<Project> projectList, List<Course> courseList) {
        this(username, password, name, surname, email, age, isAdmin);
        this.courseList = courseList;
    }

    public User(String username, String password, String name, String surname, String email, int age, boolean isAdmin, List<Project> projectList, List<Course> courseList, Long id) {
        this(username, password, name, surname, email, age, isAdmin, projectList, courseList);
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
