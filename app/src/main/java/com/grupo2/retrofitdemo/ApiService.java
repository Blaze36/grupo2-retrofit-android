package com.grupo2.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/** Interfaz que define los endpoints. Retrofit crea la implementación. */
public interface ApiService {

    // GET https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    Call<List<Post>> getPosts();

    // GET .../posts/1  (@Path reemplaza {id})
    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int id);

    // GET .../posts?userId=1  (@Query agrega el parámetro a la URL)
    @GET("posts")
    Call<List<Post>> getPostsByUser(@Query("userId") int userId);

    // POST .../posts  (@Body se convierte a JSON)
    @POST("posts")
    Call<Post> createPost(@Body Post post);

    // PUT .../posts/1  (reemplaza el recurso completo)
    @PUT("posts/{id}")
    Call<Post> updatePost(@Path("id") int id, @Body Post post);

    // PATCH .../posts/1  (modifica solo algunos campos)
    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    // DELETE .../posts/1
    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
