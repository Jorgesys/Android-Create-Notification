package com.jorgesys.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification(getDate());
            }
        });


    }

    //Create notification
    private void sendNotification(String message) {

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default","Channel name", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Channel description");
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "default");

        Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My notification")
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setContentText(message)
                .setContentIntent(pendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(getRandomNumber(0,1000), mBuilder.build());
    }

    private String getDate(){
        DateFormat dfDate = new SimpleDateFormat("yyyy/MM/dd");
        String date=dfDate.format(Calendar.getInstance().getTime());
        DateFormat dfTime = new SimpleDateFormat("HH:mm");
        String time = dfTime.format(Calendar.getInstance().getTime());

        return date + " " + time;
    }

    private int getRandomNumber(int min,int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }
}
