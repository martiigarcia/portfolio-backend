package com.springproyect.model;

import jakarta.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String percentage;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Skill() {

    }

    public Skill(String title, String percentage, User user) {
        this.title = title;
        this.percentage = percentage;
        this.user = user;
    }

    public Skill(String title, String percentage, User user, Long id) {
        this(title, percentage, user);
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

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", percentage='" + percentage + '\'' +
                '}';
    }
}
