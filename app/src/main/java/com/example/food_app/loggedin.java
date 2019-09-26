package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.like.LikeButton;
import com.like.OnLikeListener;

import java.io.Serializable;


public class loggedin extends AppCompatActivity implements OnLikeListener{

    Button b2,b3;
    Button oo;
    LikeButton h1,h2,h3,h4;
    public int food1_like,food2_like,food3_like,food4_like;
    public String p;
    String po1,po2,po3,po4;
    int f1c=0,f2c=0,f3c=0,f4c=0;
    TextView tt1,tt2,tt3,tt4;
    int total;
    StringBuilder pd = new StringBuilder();
    StringBuilder rt = new StringBuilder();

    Button f1_p,f1_m,f2_p,f2_m,f3_p,f3_m,f4_p,f4_m;

    public static final String PREFS_NAME = "LoginDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);

        oo=findViewById(R.id.button14);

        tt1=findViewById(R.id.textView6);
        tt2=findViewById(R.id.textView3);
        tt3=findViewById(R.id.textView5);
        tt4=findViewById(R.id.textView4);
        tt1.setText("₹50-0");
        tt2.setText("₹70-0");
        tt3.setText("₹90-0");
        tt4.setText("₹100-0");

        h1=findViewById(R.id.star_button1);
        h2=findViewById(R.id.star_button2);
        h3=findViewById(R.id.star_button3);
        h4=findViewById(R.id.star_button4);

        f1_p=findViewById(R.id.button6);
        f1_m=findViewById(R.id.button5);

        f2_p=findViewById(R.id.button8);
        f2_m=findViewById(R.id.button7);

        f3_p=findViewById(R.id.button10);
        f3_m=findViewById(R.id.button9);

        f4_p=findViewById(R.id.button12);
        f4_m=findViewById(R.id.button11);

        if(f1c==0){
            f1_m.setEnabled(false);
        }

        if(f2c==0){
            f2_m.setEnabled(false);
        }

        if(f3c==0){
            f3_m.setEnabled(false);
        }

        if(f4c==0){
            f4_m.setEnabled(false);
        }
        f1_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                f1c=f1c-1;
                if(f1c==0){
                    f1_m.setEnabled(false);
                }
                tt1.setText("₹50-"+f1c);

            }
        });
        f2_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                f2c=f2c-1;
                if(f2c==0){
                    f2_m.setEnabled(false);
                }
                tt2.setText("₹70-"+f2c);

            }
        });
        f3_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                f3c=f3c-1;
                if(f3c==0){
                    f3_m.setEnabled(false);
                }
                tt3.setText("₹90-"+f3c);

            }
        });
        f4_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f4c=f4c-1;
                if(f4c==0){
                    f4_m.setEnabled(false);
                }
                tt4.setText("₹100-"+f4c);

            }
        });


        f1_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                f1_m.setEnabled(true);

                f1c=f1c+1;
                tt1.setText("₹50-"+f1c);

            }
        });
        f2_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                f2_m.setEnabled(true);

                f2c=f2c+1;
                tt2.setText("₹70-"+f2c);

            }
        });
        f3_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f3_m.setEnabled(true);

                f3c= f3c+1;
                tt3.setText("₹90-"+f3c);

            }
        });
        f4_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                f4_m.setEnabled(true);

                f4c=f4c+1;
                tt4.setText("₹100-"+f4c);

            }
        });






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

        h1.setOnLikeListener(this);
        h2.setOnLikeListener(this);
        h3.setOnLikeListener(this);
        h4.setOnLikeListener(this);

        oo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                total=(f1c*50)+(f2c*70)+(f3c*90)+(f4c*100);
                if(f1c!=0){
                    pd.append("food 1 ");
                }
                if(f2c!=0){
                    pd.append("food 2 ");
                }
                if(f3c!=0){
                    pd.append("food 3 ");
                }
                if(f4c!=0){
                    pd.append("food 4 ");
                }

                favfoo();

                Intent pay = new Intent(getApplicationContext(),pay.class);
                pay.putExtra("t_pay",total);
                pay.putExtra("order_detail", (Serializable) pd);
                startActivity(pay);
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
                editor.remove("fav_food");
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

    @Override
    public void liked(LikeButton h1) {

        LikeButton y1,y2,y3,y4;
        y1=findViewById(R.id.star_button1);
        y2=findViewById(R.id.star_button2);
        y3=findViewById(R.id.star_button3);
        y4=findViewById(R.id.star_button4);

        if( h1 == y1){
            Toast.makeText(getApplicationContext(),"liked first",Toast.LENGTH_SHORT).show();

            rt.append("food1 ");

        }

        if( h1 == y2){
            Toast.makeText(getApplicationContext(),"liked second",Toast.LENGTH_SHORT).show();

            rt.append("food2 ");

        }

        if( h1 == y3){
            Toast.makeText(getApplicationContext(),"liked third",Toast.LENGTH_SHORT).show();

            rt.append("food3 ");

        }

        if( h1 == y4){
            Toast.makeText(getApplicationContext(),"liked fourth",Toast.LENGTH_SHORT).show();

            rt.append("food4 ");

        }


    }


    @Override
    public void unLiked(LikeButton h2) {

        LikeButton y1,y2,y3,y4;
        y1=findViewById(R.id.star_button1);
        y2=findViewById(R.id.star_button2);
        y3=findViewById(R.id.star_button3);
        y4=findViewById(R.id.star_button4);

        if( h2 == y1){
            Toast.makeText(getApplicationContext(),"unliked first",Toast.LENGTH_SHORT).show();


        }

        if( h2 == y2){
            Toast.makeText(getApplicationContext(),"unliked second",Toast.LENGTH_SHORT).show();

        }

        if( h2 == y3){
            Toast.makeText(getApplicationContext(),"unliked third",Toast.LENGTH_SHORT).show();


        }

        if( h2 == y4){
            Toast.makeText(getApplicationContext(),"unliked fourth",Toast.LENGTH_SHORT).show();

        }

    }


    private void favfoo() {

        new sharepref(this).favfood(rt);
    }
}
