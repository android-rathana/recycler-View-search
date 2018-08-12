package com.example.rathana.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rathana.recyclerviewdemo.R;
import com.example.rathana.recyclerviewdemo.model.Film;

import java.io.File;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder>{

    List<Film> films;
    Context context;
    public FilmAdapter(Context context,List<Film> films) {
        this.context=context;
        this.films = films;
    }

    public void setFilms(List<Film> films) {
        this.films.addAll(films);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.film_item_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Film film=this.films.get(position);
        //set data
        holder.thumb.setImageResource(film.getThumb());
        holder.title.setText(film.getTitle());
        holder.channel.setText(film.getChannel());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+film.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.films.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView thumb;
        private TextView title;
        private TextView channel;
        public ViewHolder(View itemView) {
            super(itemView);
            thumb=itemView.findViewById(R.id.thumb);
            title=itemView.findViewById(R.id.title);
            channel=itemView.findViewById(R.id.channel);
        }
    }

}
