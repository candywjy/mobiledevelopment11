package com.example.candy.belajarsound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //MediaPlayer audioBackground;
    private MediaPlayer player;
    private Button lagu1,lagu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lagu1 = (Button) this.findViewById(R.id.lagu1);
        lagu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaySound(1);
            }

        });

        lagu2 = (Button) this.findViewById(R.id.lagu2);
        lagu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                PlaySound(2);
            }
        });
    }
@Override
public void onPause(){
    try {
        super.onPause();
        player.pause();}
    catch ( Exception e){

    }
}
private  void  PlaySound (int arg){
    try{
        if (player.isPlaying()){
    player.stop();
    player.release();
        }
    }catch (Exception e){
        Toast.makeText(this,"Masuk Exception", Toast.LENGTH_LONG).show();
    }
    if (arg ==  1){
        Toast.makeText(this, "Sedang Memainkan lagu1",Toast.LENGTH_LONG).show();
        player = MediaPlayer.create(this, R.raw.lagu);
    }
    else if (arg == 2) {
        Toast.makeText(this,"Sedang memainkan lagu2", Toast.LENGTH_LONG).show();
        player = MediaPlayer.create(this, R.raw.lagu2);
    }
    player.setLooping(false);
    player.start();
    }
}