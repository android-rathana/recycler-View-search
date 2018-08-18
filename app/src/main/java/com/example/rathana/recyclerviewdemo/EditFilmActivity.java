package com.example.rathana.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.rathana.recyclerviewdemo.model.Film;

public class EditFilmActivity extends AppCompatActivity {

    private EditText title, channel;
    private Button btnSaveChange;
    private int itemPosition;
    private static final String TAG = "EditFilmActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_film);

        title=findViewById(R.id.title);
        channel=findViewById(R.id.channel);
        btnSaveChange=findViewById(R.id.btnSaveChange);

        //get data for first screen
        if(getIntent()!=null){
            Film film=getIntent().getParcelableExtra("data");
            title.setText(film.getTitle());
            channel.setText(film.getChannel());
            itemPosition=getIntent().getIntExtra("position",0);
        }

        btnSaveChange.setOnClickListener(v->{
            Film film=getFormData();
            Bundle bundle=new Bundle();
            bundle.putParcelable("data",film);
            Intent i=new Intent();
            i.putExtras(bundle);
            i.putExtra("position",itemPosition);
            setResult(RESULT_OK,i);
            Log.e(TAG, "onCreate: "+film );
            finish();
        });
    }

    public Film getFormData(){
        Film film =new Film();
        film.setTitle(title.getText().toString());
        film.setThumb(R.drawable.kangaroo);
        film.setChannel(channel.getText().toString());

        return film;
    }

}
