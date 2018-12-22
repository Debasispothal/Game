package com.example.a1602366.memorizes;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.io.File;
import java.util.ArrayList;

public class player extends AppCompatActivity  {
    ArrayList<File> song;
    int pos;
   static MediaPlayer mp;
    Uri u;
    Thread seek;
    int dec=0;
    SeekBar seekBar;
    Button button17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);






        Button button10=(Button) findViewById(R.id.button10);
        Button button11=(Button) findViewById(R.id.button11);

        Button button13=(Button) findViewById(R.id.button13);
        Button button12=(Button) findViewById(R.id.button12);
        Button button15=(Button) findViewById(R.id.button15);
        Button button14=(Button) findViewById(R.id.button14);
         button17=(Button) findViewById(R.id.button17);
         seekBar=(SeekBar) findViewById(R.id.seekBar);


        /*seek=new Thread(){
            @Override
            public void run(){
                int total=mp.getDuration();
                int curr=0;

                while(curr<total){
                    try {
                        sleep(500);
                        curr=mp.getCurrentPosition();
                        seekBar.setProgress(curr);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        };*/

        if(mp!=null){
            mp.stop();
            mp.release();

        }

        Intent i=getIntent();
        Bundle b=i.getExtras();
        song=(ArrayList) b.getParcelableArrayList("songs");
        pos=b.getInt("pos",0);
        u=Uri.parse(song.get(pos).toString());
        mp=MediaPlayer.create(getApplicationContext(),u);
        mp.start();
        //seekBar.setMax(mp.getDuration());
        //seek.start();

        Intent i1=new Intent(this,music.class);
        i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pi=PendingIntent.getActivity(this,0,i1,0);

        NotificationCompat.Builder nb = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.not)
                .setContentTitle("song")
                .setContentText(song.get(pos).toString())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pi)
                .setAutoCancel(true);
        NotificationManager nm=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(23,nb.build());




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            mp.seekTo(seekBar.getProgress());
            }
        });






        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mp.stop();
                    mp.release();

                if(pos+1>=song.size()){
                    pos=0;
                }
                else{
                    pos++;
                }

                    u = Uri.parse(song.get(pos).toString());
                    mp = MediaPlayer.create(getApplicationContext(), u);
                mp.start();
                seekBar.setMax(mp.getDuration());

            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(pos<=0){
                        pos=song.size()-1;
                    }
                    else{
                        pos--;
                    }
                    mp.stop();
                    mp.release();

                    u = Uri.parse(song.get(pos).toString());
                    mp = MediaPlayer.create(getApplicationContext(), u);
                mp.start();
                seekBar.setMax(mp.getDuration());

            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.seekTo(mp.getCurrentPosition()-5000);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.seekTo(mp.getCurrentPosition()+5000);
            }
        });

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 Boolean res=true;
                if(dec==0) {
                res=true;
                    dec=1;
                    button17.setText("loop off");
                }
                else if(dec==1) {
                res=false;
                    dec=0;
                    button17.setText("loop on");
                }

                    mp.setLooping(res);

                }

        });



    }

}
