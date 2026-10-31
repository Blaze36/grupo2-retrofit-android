package com.grupo2.retrofitdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/** Puente entre la lista de objetos Post y las filas del RecyclerView. */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.VH> {

    private List<Post> lista = new ArrayList<>();

    public void setData(List<Post> nuevos) {
        lista = nuevos;
        notifyDataSetChanged(); // avisa al RecyclerView que debe redibujar
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Post p = lista.get(position);
        holder.titulo.setText(p.getId() + ". " + p.getTitle());
        holder.cuerpo.setText(p.getBody());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        final TextView titulo;
        final TextView cuerpo;

        VH(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tvTitulo);
            cuerpo = itemView.findViewById(R.id.tvCuerpo);
        }
    }
}
