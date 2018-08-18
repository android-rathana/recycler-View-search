package com.example.rathana.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rathana.recyclerviewdemo.R;
import com.example.rathana.recyclerviewdemo.callback.ItemClickCallback;
import com.example.rathana.recyclerviewdemo.model.Film;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder>{

    List<Film> films;
    Context context;
    ItemClickCallback callback;
    public FilmAdapter(Context context,List<Film> films) {
        this.context=context;
        this.films = films;
        this.callback= (ItemClickCallback) context;
    }

    public void setFilms(List<Film> films) {
        this.films.addAll(films);
        notifyDataSetChanged();
        Log.e(TAG, "setFilms: films Size "+this.films.size()  + " new Films Size "+films.size());
    }

    public void replaceFilms(List<Film> films){
        this.films.clear();
        this.films.addAll(films);
        notifyDataSetChanged();
    }

    public void clearFilms(){
        this.films.clear();
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

        holder.btnPopupMenu.setOnClickListener(v->{
            PopupMenu menu =new PopupMenu(context,v);
            menu.inflate(R.menu.popup_menu);
            menu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()){
                    case  R.id.edit:
                        callback.onLClickWithObject(film,holder.getAdapterPosition());
                        showMessage("edit");
                        return true;
                    case R.id.remove:
                        removeItem(film,holder.getAdapterPosition());
                        showMessage("remove");
                        return true;
                }
                return false;
            });
            menu.show();
        });
    }

    private void showMessage(String smg){
        Toast.makeText(context, smg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public int getItemCount() {
        return this.films.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView thumb;
        private TextView title;
        private TextView channel;
        private ImageView btnPopupMenu;
        public ViewHolder(View itemView) {
            super(itemView);
            thumb=itemView.findViewById(R.id.thumb);
            title=itemView.findViewById(R.id.title);
            channel=itemView.findViewById(R.id.channel);
            btnPopupMenu=itemView.findViewById(R.id.btnPopupMenu);
        }
    }

    public void removeItem(Film film, int position){
        this.films.remove(film);
        notifyItemRemoved(position);
    }

    public void setFilm(Film film){
        this.films.add(0,film);
        notifyItemInserted(0);
    }
    public void updateFilm(Film film,int position){
        //int position =films.indexOf(film);
        this.films.set(position,film);
        notifyItemChanged(position);
    }

    private static final String TAG = "FilmAdapter";

}
