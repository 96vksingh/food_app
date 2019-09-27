package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class pay extends AppCompatActivity {

    private final String CHANNEL_ID = "personal_notification";
    private final String channel_name="test";

    private final int NOTIFICATION_ID=001;

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

                NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,channel_name, NotificationManager.IMPORTANCE_HIGH);
                notificationChannel.enableLights(true);
                notificationChannel.enableVibration(true);
                notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(notificationChannel);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
                builder.setSmallIcon(R.drawable.logovk1);
                builder.setContentTitle("food app");
                builder.setContentText("your order is getting prepared and will be soon delivered");
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
                Toast.makeText(getApplicationContext(),"payment",Toast.LENGTH_SHORT).show();

                Intent go = new Intent(getApplicationContext(),loggedin.class);
                startActivity(go);
            }
        });

    }
}
