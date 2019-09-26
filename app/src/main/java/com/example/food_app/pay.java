package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pay extends AppCompatActivity {

    TextView yt;
    String overall;
    Button ut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        ut=findViewById(R.id.button13);
        yt=findViewById(R.id.textView7);

        Intent ge = getIntent();
        int y=ge.getIntExtra("t_pay",0);
        String da=ge.getStringExtra("order_detail").toString();
        overall="your order is "+da+" and total amount to pay is ₹"+y;
        yt.setText(overall);

        ut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent go = new Intent(getApplicationContext(),loggedin.class);
                startActivity(go);
            }
        });

    }
}
