package com.grupo2.retrofitdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RetrofitDemo";

    private TextView tvEstado;
    private Button btnReintentar;
    private PostAdapter adapter;
    private ApiService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEstado = findViewById(R.id.tvEstado);
        btnReintentar = findViewById(R.id.btnReintentar);
        RecyclerView recycler = findViewById(R.id.recyclerPosts);

        adapter = new PostAdapter();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        api = RetrofitClient.getApi();
        btnReintentar.setOnClickListener(v -> cargarPosts());

        cargarPosts();
    }

    /** Flujo: App -> petición HTTP -> API REST -> JSON -> objetos Post -> pantalla. */
    private void cargarPosts() {
        tvEstado.setText("Cargando...");
        btnReintentar.setVisibility(View.GONE);

        // enqueue(): ejecución asíncrona, no bloquea la pantalla
        api.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Post> posts = response.body();
                    Log.d(TAG, "Código " + response.code() + ", posts recibidos: " + posts.size());
                    tvEstado.setText("Posts recibidos: " + posts.size());
                    adapter.setData(posts);
                } else {
                    // El servidor respondió, pero con error (404, 500, ...)
                    mostrarError("Error HTTP " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                // No hubo respuesta: sin internet, tiempo agotado, etc.
                Log.e(TAG, "Fallo de conexión", t);
                mostrarError("Sin conexión: " + t.getMessage());
            }
        });
    }

    private void mostrarError(String mensaje) {
        tvEstado.setText(mensaje);
        btnReintentar.setVisibility(View.VISIBLE);
    }
}
