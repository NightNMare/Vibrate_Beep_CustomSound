package com.example.sunrin.myapplication;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1:
                Vibrator vb = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vb.vibrate(1000);
                Log.e("msg","Vibrate");
                break;

            case R.id.btn2:
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringtone = RingtoneManager.getRingtone(this,notification);
                ringtone.play();
                Log.e("msg","Beep!");
                break;
            case R.id.btn3:
                MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.fallbackring);
                mediaPlayer.start();
                Log.e("msg","Custom sound");
                break;

        }
    }
}
