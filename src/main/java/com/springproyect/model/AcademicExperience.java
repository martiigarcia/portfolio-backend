package com.springproyect.model;

import jakarta.persistence.*;

@Entity
public class AcademicExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String place;
    private String period;
    private String type;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public AcademicExperience() {

    }

    public AcademicExperience(String title, String place, String period, String type, User user) {
        this.title = title;
        this.place = place;
        this.period = period;
        this.type = type;
        this.user = user;
    }

    public AcademicExperience(String title, String place, String period, String type, User user, Long id) {
        this(title, place, period, type, user);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AcademicExperience{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", place='" + place + '\'' +
                ", period='" + period + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
