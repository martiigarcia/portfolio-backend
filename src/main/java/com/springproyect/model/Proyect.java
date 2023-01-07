package com.springproyect.model;

import jakarta.persistence.*;

@Entity
public class Proyect {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String description;
    private String period;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Proyect() {

    }

    public Proyect(String name, String description, String period, User user) {
        this.name = name;
        this.description = description;
        this.period = period;
        this.user = user;
    }

    public Proyect(String name, String description, String period, User user, Long id) {
        this(name, description, period, user);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", period='" + period + '\'' +
                '}';
    }
}
