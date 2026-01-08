package com.anil.sociax.model;

public class Post {

    private Integer id;          // IMPORTANT: Integer (not int) fixes 400 null->int error
    private String title;
    private String content;
    private String category;
    private String city;

    // No-args constructor (needed by Jackson)
    public Post() {
    }

    // Constructor without id (client doesn't send id)
    public Post(String title, String content, String category, String city) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.city = city;
    }

    // Full constructor
    public Post(Integer id, String title, String content, String category, String city) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
