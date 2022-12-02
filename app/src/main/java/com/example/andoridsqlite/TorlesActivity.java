package com.example.andoridsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TorlesActivity extends AppCompatActivity {

    private EditText editTextIdTor;
    private Button buttontoles;
    private Button buttonvissza;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torles);
        init();
        buttonvissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TorlesActivity.this, MainActivity.class));
                finish();
            }
        });
        buttontoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=editTextIdTor.getText().toString().trim();
                if (id.isEmpty()){
                    Toast.makeText(TorlesActivity.this, "Minden mező kitöltése kötelező", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (adatbazis.torles(id)==0){
                        Toast.makeText(TorlesActivity.this, "Nincs ilyen id-rekord", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(TorlesActivity.this, "Sikeres törlés", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void init(){
        editTextIdTor=findViewById(R.id.editTextIdTor);
        buttontoles=findViewById(R.id.buttonTorles);
        buttonvissza=findViewById(R.id.buttonVissza);
        adatbazis=new DBHelper(TorlesActivity.this);
    }
}