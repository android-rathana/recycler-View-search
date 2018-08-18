package com.example.rathana.recyclerviewdemo.callback;

import com.example.rathana.recyclerviewdemo.model.Film;

public interface ItemClickCallback {
    void onLClickWithObject(Film film,int position);
}
