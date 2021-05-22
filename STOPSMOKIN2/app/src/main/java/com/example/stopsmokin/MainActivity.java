package com.example.stopsmokin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import static androidx.core.app.NotificationCompat.PRIORITY_DEFAULT;
import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;

public class MainActivity extends AppCompatActivity {
    private TextView TW;
    private TextView TW1;
    private int  i = 0;
    private int cost = 0;
    private int default_cost = 0;
    private int cost1 = 0;
    private int default_number = 10;
    private int cost2 = 0;
    private int number = 10;
    private double pachka = 0;
    private double pachka1 = 0;
    private boolean load = false;
    //private int cost2 = 0;
    //------------ уведомления
    private NotificationManager notificationManager;
    private static final int NOTYFY_ID = 1;
    private static final String CHANNEL_ID = "CHANNEL_ID";
    public Button b1, b2, b3;
    private ImageButton ib1;
    private SharedPreferences sPref;
    private final String SAVED = "saved_text";
    private final String SAVED1 = "saved_text1";
    private final String SAVED2 = "saved_text2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        if (prefs.getBoolean("isFirstRun", true)) {
            // первый запуск
            Intent intent1 = new Intent(MainActivity.this, firstentry.class);
            saveText();
            startActivity(intent1);

        } else {
            // уже не первый
            loadText();
            load = true;
        }
        prefs.edit().putBoolean("isFirstRun", false).apply();
        //SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        TW = findViewById(R.id.fordays);
        TW.setText(Integer.toString(i));
        TW1 = findViewById(R.id.formoney);
        TW1.setText(Integer.toString(cost));
        b1 = findViewById(R.id.testbutton);
        b2 = findViewById(R.id.powerlessbutton);
        b3 = findViewById(R.id.achivments);
        ib1 = findViewById(R.id.settings);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, firstentry.class);
                startActivity(intent1);
                //saved = false;
            }
        });

        //startService(new Intent(this, NotService.class));


//            loadText();
//            Intent intent = getIntent();
//            cost2 = intent.getIntExtra("cost", default_cost);
//            cost1 = cost;
//            cost += cost2;
//
//            Intent intent = getIntent();
//            cost = intent.getIntExtra("cost", default_cost);
//            cost1 = cost;


        //
//        if (load)
//        {
//            cost2 = intent.getIntExtra("cost", default_cost);
//            //cost += cost2;
//            number = intent.getIntExtra("number", default_number);
//            pachka = (double) number / 20;
//            cost1 = cost;
//            pachka1 = pachka;
//            cost *= pachka1;
//            cost += cost2;
//        }
//        else
//        {
//            cost = intent.getIntExtra("cost", default_cost);
//            cost1 = cost;
//            number = intent.getIntExtra("number", default_number);
//            pachka = (double) number / 20;
//            pachka1 = pachka;
//            cost *= pachka1;
//        }
        if (!load)
        {
            Intent intent = getIntent();
            cost = intent.getIntExtra("cost", default_cost);
            cost1 = cost;
            number = intent.getIntExtra("number", default_number);
            pachka = (double) number / 20;
            pachka1 = pachka;
            cost *= pachka1;
            //saveText();
        }
        else
        {
            Intent intent = getIntent();
            cost1 = intent.getIntExtra("cost", default_cost);
            //Toast.makeText(MainActivity.this, Integer.toString(cost1), Toast.LENGTH_LONG).show();
            number = intent.getIntExtra("number" , default_number);
            //Toast.makeText(MainActivity.this, Integer.toString(cost1), Toast.LENGTH_LONG).show();
            pachka = (double) number / 20;
            //Toast.makeText(MainActivity.this, Double.toString(cost1), Toast.LENGTH_LONG).show();
            pachka1 = pachka;
            //cost1 *= pachka1;
            //cost += cost1;
            //saveText();
        }




        notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
                Intent intent = new Intent(MainActivity.this, Achivments.class);
                intent.putExtra("cost1", (int)cost);
                intent.putExtra("number1", i);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cost = 0;
                i = 0;
                TW.setText(Integer.toString(i));
                TW1.setText(Integer.toString(cost));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Achivments.class);
                startActivity(intent);
            }
        });
    }
    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        SharedPreferences.Editor ed1 = sPref.edit();
        SharedPreferences.Editor ed2 = sPref.edit();
        ed.putString(SAVED, Integer.toString(cost));
        ed1.putString(SAVED1, Integer.toString(number));
        ed2.putString(SAVED2, Integer.toString(i));
        ed.commit();
        ed1.commit();
        ed2.commit();
    }
    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String Saved = sPref.getString(SAVED, "");
        String Saved1 = sPref.getString(SAVED1, "");
        String Saved2 = sPref.getString(SAVED2, "");
        cost = Integer.parseInt(Saved);
        //Toast.makeText(MainActivity.this, Integer.toString(cost), Toast.LENGTH_LONG).show();
        number = Integer.parseInt(Saved1);
        i = Integer.parseInt(Saved2);
        //TW1.setText(Saved);
        //TW.setText(Saved1);
    }
    String BROADCAST_ACTION = "com.example.uniqueTag";
    public void addNote()
    {
        pachka += pachka1;
        i++;
        cost += cost1 * pachka1;
        TW.setText(Integer.toString(i));
        TW1.setText(Integer.toString(cost));


        //Toast.makeText(MainActivity.this, Integer.toString(cost1), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        Intent noIntent = new Intent(this, NotificNo.class);
        Intent yesIntent = new Intent(this, NotificYes.class);
        PendingIntent YesPegIntent = PendingIntent.getActivity(this, 0, yesIntent, PendingIntent.FLAG_ONE_SHOT);
        noIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent noPegIntent = PendingIntent.getActivity(this, 0, noIntent, PendingIntent.FLAG_ONE_SHOT);
        //PendingIntent Yesintent  = new
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .setContentTitle("Заголовок")
                        .setContentText("Вы куриили сегодня?")
                        .setPriority(PRIORITY_DEFAULT)
                        .addAction(R.drawable.ic_launcher_foreground, "ДА",YesPegIntent)
                        .addAction(R.drawable.ic_launcher_foreground, "НЕТ", noPegIntent);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(NOTYFY_ID, notificationBuilder.build());
        saveText();
    }

    public static void createChannelIfNeeded(NotificationManager manager)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }

}