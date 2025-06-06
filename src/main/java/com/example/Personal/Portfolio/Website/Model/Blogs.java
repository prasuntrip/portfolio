package com.example.Personal.Portfolio.Website.Model;

import jakarta.persistence.*;

@Entity
public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private String author;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;
    private String imageURL;

    // NEW FIELD


    public Blogs() {

    }

    public Blogs(int id, String imageURL, String title, String author, String content, String description) {
        this.id = id;
        this.imageURL = imageURL;
        this.title = title;
        this.author = author;
        this.content = content;
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
