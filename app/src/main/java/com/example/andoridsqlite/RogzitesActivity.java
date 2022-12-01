package com.example.andoridsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RogzitesActivity extends AppCompatActivity {

    private EditText vezeteknev;
    private EditText keresztnev;
    private EditText jegy;
    private Button rogzitesbutton;
    private Button backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rogzites);
        init();
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RogzitesActivity.this, MainActivity.class));
                finish();
            }
        });
    }
    private void init(){
        vezeteknev=findViewById(R.id.vezeteknev);
        keresztnev=findViewById(R.id.keresztnev);
        jegy=findViewById(R.id.jegy);
        rogzitesbutton=findViewById(R.id.rogzitesbutton);
        backbutton=findViewById(R.id.backbutton);
    }
}