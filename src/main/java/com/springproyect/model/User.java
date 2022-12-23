package com.springproyect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


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

    public User(String password, String name, String surname, String email, int age, boolean isAdmin) {
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.isAdmin = isAdmin;
    }

//    public User(String username, String password, String name, String surname, String email, int age, boolean isAdmin, Long id) {
//        this(username, password, name, surname, email, age, isAdmin);
//        this.id = id;
//    }

    public User(String password, String name, String surname, String email, int age, boolean isAdmin, List<Project> projectList, List<Course> courseList) {
        this(password, name, surname, email, age, isAdmin);
        this.projectList = projectList;
        this.courseList = courseList;
    }

    public User(String password, String name, String surname, String email, int age, boolean isAdmin, List<Project> projectList, List<Course> courseList, Long id) {
        this(password, name, surname, email, age, isAdmin, projectList, courseList);
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setIsAdmin(boolean admin) {
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

    public void addProjectToList(Project project) {
        this.projectList.add(project);
    }

    public void addCourseToList(Course course) {
        this.courseList.add(course);
    }
    public boolean containsProject(Long id) {
        boolean exist = false;
        for (Project project : this.projectList) {
            if (project.getId() == id) {
                exist = true;
            }
        }
        return exist;
    }

    public boolean containsCourse(Long id) {
        boolean exist = false;
        for (Course course : this.courseList) {
            if (course.getId() == id) {
                exist = true;
            }
        }
        return exist;
    }

    public void removeCourse(Long id){
        Course coursex = null;
        for (Course course : this.courseList) {
            if (course.getId() == id) {
                coursex = course;
            }
        }
        if(coursex != null){
            this.courseList.remove(coursex);
        }
    }

    public void removeProject(Long id){
        Project projectx = null;
        for (Project project : this.projectList) {
            if (project.getId() == id) {
                projectx = project;
            }
        }
        if(projectx != null){
            this.projectList.remove(projectx);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
