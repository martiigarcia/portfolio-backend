package com.springproyect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String password;
    private String name;
    private String surname;
    private String email;
    private int age;
    private boolean isAdmin;

    @Column(columnDefinition = "varchar(1026)")
    private String information;

    protected User() {

    }

    public User(String password, String name, String surname, String email, int age, boolean isAdmin, String information) {
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.isAdmin = isAdmin;
        this.information = information;
    }

    public User(String password, String name, String surname, String email, int age, boolean isAdmin, String information, Long id) {
        this(password, name, surname, email, age, isAdmin, information);
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
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
                ", information='" + information + '\'' +
                '}';
    }

//    public List<Project> getProjectList() {
//        return projectList;
//    }
//
//    public void setProjectList(List<Project> projectList) {
//        this.projectList = projectList;
//    }
//
//    public void addProjectToList(Project project) {
//        this.projectList.add(project);
//    }


//    public boolean containsProject(Long id) {
//        boolean exist = false;
//        for (Project project : this.projectList) {
//            if (project.getId() == id) {
//                exist = true;
//            }
//        }
//        return exist;
//    }


//    public void removeProject(Long id) {
//        Project projectx = null;
//        for (Project project : this.projectList) {
//            if (project.getId() == id) {
//                projectx = project;
//            }
//        }
//        if (projectx != null) {
//            this.projectList.remove(projectx);
//        }
//    }


}
