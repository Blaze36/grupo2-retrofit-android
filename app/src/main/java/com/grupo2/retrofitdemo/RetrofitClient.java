package com.grupo2.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/** Configura Retrofit una sola vez y lo reutiliza en toda la app. */
public class RetrofitClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/"; // debe terminar en "/"
    private static Retrofit retrofit;

    public static ApiService getApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // JSON <-> objetos Java
                    .build();
        }
        return retrofit.create(ApiService.class);
    }
}
