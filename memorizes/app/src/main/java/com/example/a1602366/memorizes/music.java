package com.example.a1602366.memorizes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by 1602366 on 5/2/2018.
 */

public class music extends AppCompatActivity{
    ListView li;
    String items[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
            li=(ListView) findViewById(R.id.listview);

        final ArrayList<File> song = findsong(Environment.getExternalStorageDirectory());
        items=new String[song.size()];
        for(int i=0;i<song.size();i++){
            items[i]=song.get(i).getName().toString().replace("mp3","");
        }
        ArrayAdapter<String> ad;
        ad = new ArrayAdapter<String>(getApplicationContext(),R.layout.file,R.id.textView4,items);
        li.setAdapter(ad);
      li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              startActivity(new Intent(getApplicationContext(),player.class).putExtra("pos",position).putExtra("songs",song));
          }
      });
    }
    public ArrayList<File> findsong(File root){
        ArrayList <File>al=new ArrayList<File>();
        File[] file=root.listFiles();
        for(File one : file){
            if(one.isDirectory()){
                al.addAll(findsong(one));
            }
            else{
                if(one.getName().endsWith(".mp3")){
                    al.add(one);
                }
            }
        }
        return al;
    }
}
