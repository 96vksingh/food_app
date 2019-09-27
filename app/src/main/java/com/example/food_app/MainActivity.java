package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    FloatingActionButton f;
    static String data;
    static String uu,pp;
    static int ch=0;
    static int ma=0;
    Button login;
    EditText u,p;
    String u1,p1;
    CheckBox c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c=findViewById(R.id.checkBox);

        login=findViewById(R.id.button);
        u=findViewById(R.id.editText);
        p=findViewById(R.id.editText2);

        f=findViewById(R.id.floatingActionButton);

        if(MainActivity.ma==0){

            u.setVisibility(View.VISIBLE);
            p.setVisibility(View.VISIBLE);
            login.setVisibility(View.VISIBLE);
            c.setVisibility(View.VISIBLE);
            f.setEnabled(true);

        }



        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"fab clicked and going to sign in page",Toast.LENGTH_SHORT).show();

                FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                MainActivity.ch=1;
                MainActivity.ma=1;

                if(MainActivity.ma==0){

                    u.setVisibility(View.VISIBLE);
                    p.setVisibility(View.VISIBLE);
                    login.setVisibility(View.VISIBLE);
                    c.setVisibility(View.VISIBLE);

                }else{

                    u.setVisibility(View.INVISIBLE);
                    p.setVisibility(View.INVISIBLE);
                    login.setVisibility(View.INVISIBLE);
                    c.setVisibility(View.INVISIBLE);
                    f.setEnabled(false);

                }




                fagment2 fr = new fagment2();
                t.replace(R.id.fragment2,fr);
                t.addToBackStack(null);
                t.commit();


//                Intent reg = new Intent(getApplicationContext(),register.class);
//                startActivity(reg);
            }
        });





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u1=u.getText().toString();
                p1=p.getText().toString();

                if(p1.equals(pp) && u1.equals(uu)){
                    Toast.makeText(getApplicationContext(),"login success",Toast.LENGTH_SHORT).show();
                    if (c.isChecked()){
                        saveLoginDetails(u1, p1);
                    startHomeActivity();
                }
                    startHomeActivity();
                }else {
                    Toast.makeText(getApplicationContext(),"invalid login",Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (!new sharepref(this).isUserLogedOut()) {
            //user's email and password both are saved in preferences
            startHomeActivity();
        }
    }

    private void startHomeActivity() {
        Intent intent = new Intent(this, loggedin.class);
        startActivity(intent);
        finish();
    }

    private void saveLoginDetails(String email, String password) {
        new sharepref(this).saveLoginDetails(email, password);
    }


}
