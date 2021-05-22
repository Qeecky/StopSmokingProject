package com.example.stopsmokin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class NotificYes extends AppCompatActivity {
    private int cost = 0;
    private int i = 0;
    private int number  = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notific_yes);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("cost", cost);
        intent.putExtra("i", i);
        startActivity(intent);
        //intent.putExtra("number", number);

    }
}