package com.example.my.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Second extends AppCompatActivity {
    EditText username,password,repassword,city,phone,email;
    ImageButton back;
    Button signup;
    String s1,s2,s3,s4,s5,s6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        signup=(Button)findViewById(R.id.signup);
        username=(EditText)findViewById(R.id.editText3);
        password=(EditText)findViewById(R.id.editText4);
        repassword=(EditText)findViewById(R.id.editText5);
        city=(EditText)findViewById(R.id.editText6);
        phone=(EditText)findViewById(R.id.editText7);
        email=(EditText)findViewById(R.id.editText8);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=username.getText().toString();
                s2=password.getText().toString();
                s3=repassword.getText().toString();
                s4=city.getText().toString();
                s5=phone.getText().toString();
                s6=email.getText().toString();

                if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty())
                {
                    Toast.makeText(Second.this,"Enter all fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(s2.equals(s3)==false)
                    {
                        Toast.makeText(Second.this,"Passwords not Match",Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        SQLiteDatabase data = openOrCreateDatabase("magic", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists user (name varchar, password varchar, email varchar, city varchar, phone varchar)");



                        String x = "select * from user where name='" + s1 + "'";
                        Cursor cursor = data.rawQuery(x, null);

                        String y = "select * from user where email='" + s6 + "'";
                        Cursor cursor2  = data.rawQuery(y,null);

                        if (cursor.getCount() > 0) {
                            cursor.close();
                            Toast.makeText(Second.this, "User already exists ", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            cursor.close();



                            if(cursor2.getCount()>0)
                            {
                                cursor2.close();
                                Toast.makeText(Second.this,"Email already registered",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                cursor2.close();

                                data.execSQL("insert into user values ('" + s1 + "','" + s2 + "','"+s6+"','"+s4+"','"+s5+"')");
                                Toast.makeText(Second.this, "Database Updated", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Second.this, MainActivity.class);
                                startActivity(i);
                            }

                        }

                    }
                }

            }
        });
    }
}
