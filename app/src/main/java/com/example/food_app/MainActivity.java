package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText u,p;
    TextView sign;
    String u1,p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=findViewById(R.id.button);
        u=findViewById(R.id.editText);
        p=findViewById(R.id.editText2);
        sign=findViewById(R.id.textView2);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"go to sign in page",Toast.LENGTH_SHORT).show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u1=u.getText().toString();
                p1=p.getText().toString();
                if(p1.equals("123456") && u1.equals("vk")){
                    Toast.makeText(getApplicationContext(),"login success",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"invalid login",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
