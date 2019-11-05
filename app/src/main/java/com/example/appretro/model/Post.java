package com.example.appretro.model;

//Creamos una clase que va a contener todos los atributos que tiene
// un objeto json del cual se va a consumir

public class Post {
    private  int userId;
    private int id;
    private String body, title;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }
}
