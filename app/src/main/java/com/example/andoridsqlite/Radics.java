package com.example.andoridsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class Radics extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radics);
        imageView=findViewById(R.id.imageview);
        Glide.with(Radics.this).load("https://c.tenor.com/mQmxBpL4D70AAAAM/radics-radicsattila.gif").into(imageView);
        mediaPlayer = MediaPlayer.create(this, R.raw.zene);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}