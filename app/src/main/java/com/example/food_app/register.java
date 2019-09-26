package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    Button kk;
    EditText e1,e2,e3;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        kk=findViewById(R.id.button3);
        e1=findViewById(R.id.editText3);
        e2=findViewById(R.id.editText4);
        e3=findViewById(R.id.editText5);

        Toast.makeText(getApplicationContext(),"hey dude i m here",Toast.LENGTH_SHORT).show();

        kk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1=e1.getText().toString();
                s2=e2.getText().toString();

                regdetail(s1, s2);

                Intent h = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(h);

            }
        });

    }

    private void regdetail(String name, String number) {
        new sharepref(this).regdetail(name, number);
    }
}
