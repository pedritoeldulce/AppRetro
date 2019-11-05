package com.example.appretro.interfaces;

import com.example.appretro.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    //con el metodo GET vamos a hacer una consulta -> consumir datos
    @GET("posts") //anotation: trae informacion de una parte de la URI(http://......./post)
    //envia una invocacion al servidor y obtiene una respuesta que va a ser del tipo model (Post)
    //dado que sopn varios -> List
    Call<List<Post>> getPosts();
}
