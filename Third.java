package com.example.my.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
//android is old
public class Third extends AppCompatActivity {
    ImageButton b2,b3,b4,b5,b6;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b1=(Button)findViewById(R.id.button5);
        b2=(ImageButton)findViewById(R.id.button6);
        b3=(ImageButton)findViewById(R.id.button7);
        b4=(ImageButton)findViewById(R.id.button8);
        b5=(ImageButton)findViewById(R.id.button9);
        b6=(ImageButton)findViewById(R.id.button10);

       /* b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Third.this,MainActivity.class);
                startActivity(i);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(Third.this,Sixth.class);
                startActivity(j);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k= new Intent(Third.this,Seventh.class);
                startActivity(k);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m= new Intent(Third.this,Fifth.class);
                startActivity(m);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m= new Intent(Third.this,Fourth.class/*Special function*//*);
                startActivity(m);

            }
        });*/

    }
}
