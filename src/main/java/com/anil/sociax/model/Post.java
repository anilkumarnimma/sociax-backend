package com.anil.sociax.model;

public class Post {
    private Integer id;
    private String title;
    private String content;
    private String category; // JOBS / HOUSING / HELP
    private String city;

    public Post() {}

    public Post(Integer id, String title, String content, String category, String city) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.city = city;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
