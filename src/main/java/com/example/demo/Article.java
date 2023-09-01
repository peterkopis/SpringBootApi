package com.example.demo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Article {

    @Id
    @SequenceGenerator(
            name = "article_name_id",
            sequenceName = "article_name_id"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "article_name_id"
    )
    private int id;
    private String description;
    private Date addAt;
    private boolean complete;

    public Article(int id, String description, Date addAt, boolean complete) {
        this.id = id;
        this.description = description;
        this.addAt = addAt;
        this.complete = complete;
    }

    public Article() {
    }

    public Article(String description, Date addAt, boolean complete) {
        this.description = description;
        this.addAt = addAt;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAddAt() {
        return addAt;
    }

    public void setAddAt(Date addAt) {
        this.addAt = addAt;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", addAt=" + addAt +
                ", complete=" + complete +
                '}';
    }

}
