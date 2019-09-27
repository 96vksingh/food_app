package com.example.food_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class fragment1 extends Fragment {
    Handler handler;
    TextView t1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {




        t1=getView().findViewById(R.id.textView);
        t1.setVisibility(View.VISIBLE);
        Toast.makeText(getContext(),MainActivity.data,Toast.LENGTH_SHORT).show();
        t1.setText(MainActivity.data);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                t1.setVisibility(View.INVISIBLE);
            }
        },5000);


    }



    }
