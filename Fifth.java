package com.example.my.androidprojectnetcamp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Fifth extends AppCompatActivity {

    Button b1;
    Button b2,b3;
    MediaPlayer m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button14);
        b2=(Button)findViewById(R.id.button15);
        b3=(Button)findViewById(R.id.button16);
        m=MediaPlayer.create(this,R.raw.a);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.pause();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.stop();
            }
        });
    }
}
