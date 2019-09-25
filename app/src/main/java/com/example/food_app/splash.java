package com.example.food_app;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class splash extends Activity{

    Handler handler;
    VideoView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        v=findViewById(R.id.videoView);
        Uri video=Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bblank);
        v.setVideoURI(video);
//        v.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                startNextMatchingActivity();
//            }
//
//            private void startNextMatchingActivity() {
//                if (isFinishing())
//                    return;
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                finish();
//            }
//        });
        v.start();

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                finish();
            }
        },6000);

    }

}
