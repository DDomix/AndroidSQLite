package com.example.andoridsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button readbutton;
    private Button addbutton;
    private Button changebutton;
    private Button deletebutton;
    private TextView textView;

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
    }
    private void init(){
        readbutton=findViewById(R.id.readbutton);
        addbutton=findViewById(R.id.addbutton);
        changebutton=findViewById(R.id.changebutton);
        deletebutton=findViewById(R.id.deletebutton);
        textView=findViewById(R.id.textview);
    }
}