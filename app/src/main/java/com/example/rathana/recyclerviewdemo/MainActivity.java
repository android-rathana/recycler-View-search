package com.example.rathana.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rathana.recyclerviewdemo.adapter.FilmAdapter;
import com.example.rathana.recyclerviewdemo.model.Film;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFilm;
    private List<Film> films=new ArrayList();
    private FilmAdapter filmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup view
        rvFilm=findViewById(R.id.rvFilm);
        //set LayoutManager
        LinearLayoutManager layoutManager=new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );
        rvFilm.setLayoutManager(layoutManager);

        //create Adapter
        filmAdapter=new FilmAdapter(this,films);
        rvFilm.setAdapter(filmAdapter);

        //update data
        updateData();

    }

    private void updateData() {
        for(int i=0;i<50;i++){
            this.films.add(new Film("star war 2 "+i,"100K",R.drawable.kangaroo,"HRD"));
        }
        filmAdapter.setFilms(this.films);
    }
}
