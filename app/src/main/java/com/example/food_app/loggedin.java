package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loggedin extends AppCompatActivity {

    Button b2,b3;

    public static final String PREFS_NAME = "LoginDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);

        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button4);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewdat();
                FragmentTransaction f1 = getSupportFragmentManager().beginTransaction();
                fragment1 fra1 = new fragment1();
                f1.replace(R.id.fragment,fra1);
                f1.commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.remove("Email");
                editor.remove("Password");
                editor.remove("name");
                editor.remove("number");
                MainActivity.data="";
                MainActivity.pp="";
                MainActivity.uu="";
                editor.commit();
                finish();
                Intent i2= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i2);
            }
        });


    }

    private void viewdat() {

        new sharepref(this).viewdata();
    }
}
