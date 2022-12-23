package com.springproyect.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ExtraExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String description;

    protected ExtraExperience() {

    }

    public ExtraExperience(User user, String title, String description) {
        this.user = user;
        this.title = title;
        this.description = description;
    }

    public ExtraExperience(User user, String title, String description, Long id) {
        this(user, title, description);
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
        System.out.println(user);
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

    @Override
    public String toString() {
        return "ExtraExperience{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
