package com.example.andoridsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button readbutton;
    private Button addbutton;
    private Button changebutton;
    private Button deletebutton;
    private TextView textView;
    private Button radicsdance;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RogzitesActivity.class));
                finish();
            }
        });
        readbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor adatok = adatbazis.listaz();
                if (adatok.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "Nincs az adatbázisban bejegyzés", Toast.LENGTH_SHORT).show();
                } else {
                    StringBuilder bobTheBuilder = new StringBuilder();
                    while (adatok.moveToNext()){
                        bobTheBuilder.append("ID: ").append(adatok.getInt(0));
                        bobTheBuilder.append(System.lineSeparator());
                        bobTheBuilder.append("Vezetéknév ").append(adatok.getString(1));
                        bobTheBuilder.append(System.lineSeparator());
                        bobTheBuilder.append("Keresztnév ").append(adatok.getString(2));
                        bobTheBuilder.append(System.lineSeparator());
                        bobTheBuilder.append("Jegy ").append(adatok.getString(3));
                        bobTheBuilder.append(System.lineSeparator());
                        bobTheBuilder.append(System.lineSeparator());
                    }
                    textView.setText(bobTheBuilder.toString());
                }
            }
        });
        changebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ModositasActivity.class));
                finish();
            }
        });
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TorlesActivity.class));
                finish();
            }
        });
        radicsdance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Radics.class));
                finish();
            }
        });
    }

    private void init() {
        readbutton = findViewById(R.id.readbutton);
        addbutton = findViewById(R.id.addbutton);
        changebutton = findViewById(R.id.changebutton);
        deletebutton = findViewById(R.id.deletebutton);
        textView = findViewById(R.id.textview);
        radicsdance=findViewById(R.id.radicsdance);
        adatbazis = new DBHelper(MainActivity.this);
    }
}