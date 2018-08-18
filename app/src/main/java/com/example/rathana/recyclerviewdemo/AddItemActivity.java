package com.example.rathana.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.rathana.recyclerviewdemo.model.Film;

public class AddItemActivity extends AppCompatActivity {

    private EditText title,channel;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        title=findViewById(R.id.title);
        channel=findViewById(R.id.description);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v_->{
            Film film=new Film();
            film.setTitle(title.getText().toString());
            film.setChannel(channel.getText().toString());
            film.setThumb(R.drawable.kangaroo);
            Bundle b=new Bundle();
            b.putParcelable("data",film);
            Intent intent=new Intent();
            intent.putExtras(b);

            setResult(RESULT_OK,intent);
            finish();
        });
    }

}
