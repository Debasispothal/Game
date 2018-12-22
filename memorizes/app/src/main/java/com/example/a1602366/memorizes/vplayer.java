package com.example.a1602366.memorizes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;
import java.util.ArrayList;

public class vplayer extends AppCompatActivity {
    VideoView videoView;
    MediaController mc;
    ArrayList<File> video;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vplayer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        videoView=(VideoView) findViewById(R.id.videoView);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        video=(ArrayList) b.getParcelableArrayList("songs");
        pos=b.getInt("pos");
        Uri u=Uri.parse(video.get(pos).toString());
        mc=new MediaController(this);
        videoView.setVideoURI(u);
        videoView.setMediaController(mc);
        videoView.start();





    }



}
