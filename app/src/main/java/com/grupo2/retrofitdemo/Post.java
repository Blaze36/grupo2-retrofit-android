package com.grupo2.retrofitdemo;

/**
 * POJO: representa un objeto del JSON de https://jsonplaceholder.typicode.com/posts
 * Los nombres de los atributos coinciden con las claves del JSON, por eso Gson los asigna solo.
 */
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Post() { }

    public Post(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getUserId() { return userId; }
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getBody() { return body; }
}
