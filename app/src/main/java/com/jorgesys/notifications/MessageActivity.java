package com.jorgesys.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);



        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MessageActivity.this, "Date: " + getDate(), Toast.LENGTH_SHORT).show();;
            }
        });


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
