package com.example.andoridsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModositasActivity extends AppCompatActivity {

    private EditText editTextIDMod;
    private EditText editTextVezNevMod;
    private EditText editTextKerNevMod;
    private EditText editTextJegyNevMod;
    private Button buttonVisszaMod;
    private Button buttonModositMod;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modositas);
        init();
        buttonVisszaMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ModositasActivity.this, MainActivity.class));
                finish();
            }
        });
        buttonModositMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=editTextIDMod.getText().toString().trim();
                String keresztnev=editTextKerNevMod.getText().toString().trim();
                String vezeteknev=editTextVezNevMod.getText().toString().trim();
                String jegy=editTextJegyNevMod.getText().toString().trim();
                if (id.isEmpty() || keresztnev.isEmpty() ||  vezeteknev.isEmpty() || jegy.isEmpty()){
                    Toast.makeText(ModositasActivity.this, "Minden mező kitöltése kötelező", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (adatbazis.modositas(id,vezeteknev,keresztnev,jegy)==0){
                        Toast.makeText(ModositasActivity.this, "Sikertelen módósítás, nem létezik ilyen id- rekord", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(ModositasActivity.this, "Sikeres módósítás", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void init(){
        editTextIDMod=findViewById(R.id.editTextIDMod);
        editTextVezNevMod=findViewById(R.id.editTextVezNevMod);
        editTextKerNevMod=findViewById(R.id.editTextKerNevMod);
        editTextJegyNevMod=findViewById(R.id.editTextJegyMod);
        buttonModositMod =findViewById(R.id.ButtonModositMod);
        buttonVisszaMod =findViewById(R.id.ButtonVisszaMod);
        adatbazis=new DBHelper(ModositasActivity.this);
    }
}