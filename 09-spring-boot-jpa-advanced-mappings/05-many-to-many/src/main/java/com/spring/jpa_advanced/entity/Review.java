package com.spring.jpa_advanced.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    public Review() {
    }

    public Review(String name) {
        this.comment = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String name) {
        this.comment = name;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", name='" + comment + '\'' +
                '}';
    }
}
