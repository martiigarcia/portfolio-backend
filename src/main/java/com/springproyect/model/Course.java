package com.springproyect.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String description;
    private Date beginning;
    private Date ending;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user")
    private List<User> participants = new ArrayList<>();

    protected Course() {

    }

    public Course(String name, String description, Date beginning, Date ending) {
        this.name = name;
        this.description = description;
        this.beginning = beginning;
        this.ending = ending;
    }

    public Course(String name, String description, Date beginning, Date ending, List<User> participants) {
        this(name, description, beginning, ending);
        this.participants = participants;
    }

    public Course(String name, String description, Date beginning, Date ending, List<User> participants, Long id) {
        this(name, description, beginning, ending, participants);
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

    public Date getBeginning() {
        return beginning;
    }

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public Date getEnding() {
        return ending;
    }

    public void setEnding(Date ending) {
        this.ending = ending;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

}