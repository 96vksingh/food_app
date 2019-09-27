package com.example.food_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class fagment2 extends Fragment {

    public String s1,s2,s3,s4;
    EditText r1,r2,r3,r4;
    Button gt;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fagment2, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        r1=getView().findViewById(R.id.editText7);
        r2=getView().findViewById(R.id.editText8);
        r3=getView().findViewById(R.id.editText10);
        r4=getView().findViewById(R.id.editText9);
        gt=getView().findViewById(R.id.button15);

        if(MainActivity.ch==0){
            r1.setVisibility(View.INVISIBLE);
            r2.setVisibility(View.INVISIBLE);
            r3.setVisibility(View.INVISIBLE);
            r4.setVisibility(View.INVISIBLE);
            gt.setVisibility(View.INVISIBLE);
        }else{

            Toast.makeText(getContext(),"testing",Toast.LENGTH_SHORT).show();
            r1.setVisibility(View.VISIBLE);
            r2.setVisibility(View.VISIBLE);
            r3.setVisibility(View.VISIBLE);
            r4.setVisibility(View.VISIBLE);
            gt.setVisibility(View.VISIBLE);
            r1.requestFocus();
            MainActivity.ma=1;


            gt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r1.setVisibility(View.INVISIBLE);
                    r2.setVisibility(View.INVISIBLE);
                    r3.setVisibility(View.INVISIBLE);
                    r4.setVisibility(View.INVISIBLE);
                    gt.setVisibility(View.INVISIBLE);

                    s1=r1.getText().toString();
                    s2=r2.getText().toString();
                    s3=r3.getText().toString();
                    s4=r4.getText().toString();
                    MainActivity.uu=s1;
                    MainActivity.pp=s4;

                    MainActivity.ma=0;
                    MainActivity.ch=0;

                    regdetail(s1,s2,s3,s4);

                    Intent h = new Intent(getContext(),MainActivity.class);

                    startActivity(h);

                }
            });
        }

    }

    private void regdetail(String name, String number,String pas,String add) {
        new sharepref(getContext()).regdetail(name, number,pas,add);
    }


}
