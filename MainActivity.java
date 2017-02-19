package com.example.my.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login,signup;
    EditText username,password;
    String s1,s2,s3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=username.getText().toString();
                s2=password.getText().toString();
                if(s1.isEmpty()==true || s2.isEmpty()==true)
                {
                    Toast.makeText(MainActivity.this,"Fill all Fields",Toast.LENGTH_SHORT).show();
                }

                else {
                    SQLiteDatabase data = openOrCreateDatabase("magic", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists user (name varchar, password varchar, email varchar)");


                    String x = "select * from user where name='" + s1 + "' and password='" + s2 + "'";
                    Cursor cursor = data.rawQuery(x,null);


                    if(cursor.getCount()>0)
                    {
                        cursor.close();
                        Toast.makeText(MainActivity.this, "Logging in...", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, Third.class);
                        Intent j = i.putExtra("data",s1 );
                        startActivity(j);
                    }

                    else
                    {
                        cursor.close();
                        Toast.makeText(MainActivity.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(MainActivity.this,Third.class);
                startActivity(k);
            }
        });
    }
}
