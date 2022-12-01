package com.example.andoridsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RogzitesActivity extends AppCompatActivity {

    private EditText vezeteknev;
    private EditText keresztnev;
    private EditText jegy;
    private Button rogzitesbutton;
    private Button backbutton;

    private DBHelper adatbazis;

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
        rogzitesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String veznev=vezeteknev.getText().toString().trim();
                String kernev=keresztnev.getText().toString().trim();
                String jeggy=jegy.getText().toString().trim();
                if (veznev.isEmpty()|| kernev.isEmpty()||jeggy.isEmpty()){
                    Toast.makeText(RogzitesActivity.this, "Minden mező kitöltése kötelező", Toast.LENGTH_SHORT).show();
                }
                else{
                    int jegy=Integer.parseInt(jeggy);
                    if (adatbazis.rogzites(veznev,kernev,jegy)){
                        Toast.makeText(RogzitesActivity.this, "Sikeres adatrögzítés", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(RogzitesActivity.this, "Sikertelen adatrögzítés", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void init(){
        vezeteknev=findViewById(R.id.vezeteknev);
        keresztnev=findViewById(R.id.keresztnev);
        jegy=findViewById(R.id.jegy);
        rogzitesbutton=findViewById(R.id.rogzitesbutton);
        backbutton=findViewById(R.id.backbutton);
        adatbazis = new DBHelper(RogzitesActivity.this);
    }
}