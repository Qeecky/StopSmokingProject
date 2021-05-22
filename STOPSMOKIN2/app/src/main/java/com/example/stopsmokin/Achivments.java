package com.example.stopsmokin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Achivments extends AppCompatActivity {
    private int cost = 0, i = 0, defcost = 1, defday = 1;
    private ListView listView;
    private String[] achivments = { "Не курил день", "Сэкономлена 1 тыс.руб", "Не курил одну неделю", "Не курил 3 месяца", "Сэкономлено 10 тыс руб", "Не курил месяц"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achivments);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        listView = findViewById(R.id.achList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, achivments);
        listView.setAdapter(adapter);

        Intent intent = getIntent();
        cost = intent.getIntExtra("cost1", 0);
        //i = intent.getExtras().getInt("number1", 0);
        //Toast.makeText(Achivments.this, Integer.toString(cost), Toast.LENGTH_LONG).show();
        if (cost > 1000)
        {
            //listView.getAdapter().getView(1, null , null). getResources().getColor(R.color.teal_200);
        }
    }
}