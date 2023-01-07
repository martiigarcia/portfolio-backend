package com.springproyect.model;

import jakarta.persistence.*;

@Entity
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String description;
    private String period;
    private String place;

    protected WorkExperience() {

    }

    public WorkExperience(User user, String title, String description, String period, String place) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.period = period;
        this.place = place;
    }

    public WorkExperience(User user, String title, String description, String period, String place, Long id) {
        this(user, title, description, period, place);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", period='" + period + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
