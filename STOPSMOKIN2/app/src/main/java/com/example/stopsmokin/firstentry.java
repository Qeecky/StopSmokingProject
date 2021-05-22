package com.example.stopsmokin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class firstentry extends AppCompatActivity {
 private Button b3;
 private int cost = 150;
 private int number = 10;
 private SharedPreferences sPref;
 private final String SAVED = "saved_text";
 private final String SAVED1 = "saved_text1";
 private EditText fordays;
 private EditText forNumber;
 public void hideKeyboard(View view) {
     InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(firstentry.INPUT_METHOD_SERVICE);
     inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstentry2);
        b3 = findViewById(R.id.buttonsecond3);
        fordays = findViewById(R.id.second33);
        forNumber = findViewById(R.id.seocnd3);
//        fordays.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus)
//                {
//                    hideKeyboard(v);
//                }
//            }
//        });
//        forNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus)
//                {
//                    hideKeyboard(v);
//                }
//            }
//        });
        loadText();
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(firstentry.this, MainActivity.class);
                cost = Integer.parseInt(fordays.getText().toString());
                number = Integer.parseInt(forNumber.getText().toString());
                intent.putExtra("cost", cost);
                intent.putExtra("number", number);
                //Toast.makeText(firstentry.this, Integer.toString(number), Toast.LENGTH_LONG).show();
                saveText();
                startActivity(intent);
            }

            private void saveText() {
                sPref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                SharedPreferences.Editor ed1 = sPref.edit();
                ed.putString(SAVED, Integer.toString(cost));
                ed1.putString(SAVED1, Integer.toString(number));
                ed.commit();
                ed1.commit();
            }
        });
    }

    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String Saved = sPref.getString(SAVED, "");
        String Saved1 = sPref.getString(SAVED1, "");
        fordays.setText(Saved);
        forNumber.setText(Saved1);
    }
}