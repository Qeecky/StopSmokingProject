package com.example.stopsmokin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class NotificNo extends AppCompatActivity {
private int cost = 0;
private int i = 0;
private int number  = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notific_no);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}