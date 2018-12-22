package com.example.a1602366.memorizes;

import android.Manifest;
import android.app.Activity;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int count;
    String just="laku";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ch="";
                if(count==0){
                    ch="EveryDay is a chance to be successfull";
                    count=1;
                }
                else if(count==1){
                    ch="You can use the search option for searching.";
                    count=2;
                }
                else if(count==2){
                    ch="Use calcuator for quick calculation";
                    count=3;
                }
                else if(count==3){
                    ch="Use music and video button for music and video player.";
                    count=0;
                }
                Snackbar.make(view, ch, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                            }
        });
        Button button16=(Button) findViewById(R.id.button16);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,video.class);
                startActivity(i);
            }
        });




        Button button8=(Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,aboutus.class);
                startActivity(i);

            }
        });


        Button button6=(Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,search.class);
                //new line.
                startActivity(i.putExtra("text",just));

            }
        });



        Button button2 =(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,calculator.class);
                startActivity(i);

            }
        });

        Button button7=(Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,music.class);
                startActivity(i);

            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        TextView output=(TextView) findViewById(R.id.output);
        Date date= new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        int hours=cal.get(Calendar.HOUR_OF_DAY);
        if(hours>=13&&hours<=16){
            output.setText("Good afternoon.\n Hi I am memorizes");
        }
        else if(hours>=6&&hours<=12)
            output.setText("Good Morning.\n Hi I am memorizes");
        else if(hours>17&&hours<=19)
            output.setText("Good Evening.\n Hi I am memorizes");
        else
            output.setText("Good Night.\n Hi I am memorizes");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        EditText input = (EditText) findViewById(R.id.input);
        TextView output = (TextView) findViewById(R.id.output);
        String givetext = input.getText().toString();
        String ch = "How are you";
        if (givetext.contentEquals(ch) || givetext.contentEquals("how are you")) {
            output.setText("I am good How are you \n So how is your day!! ");
            input.setText("");

        } else if (givetext.contentEquals("Not so good") || givetext.contentEquals("not so good")) {
            output.setText("Not to worry tommorow will be a good day ");
            input.setText("");

        } else if (givetext.equals("HI") || givetext.equals("hi") || givetext.equals("Hi") || givetext.equals("Hello") || givetext.equals("HELLO") || givetext.equals("hello")) {
            output.setText("Hii there \n How are you");
            input.setText("");
        } else if (givetext.equals("GOOD") || givetext.equals("FINE") || givetext.equals("good") || givetext.equals("fine") || givetext.equals("Good") || givetext.equals("Fine")) {
            output.setText("Its nice to hear that:)\n");
            input.setText("");
        } else if (givetext.equals("What is you name") || givetext.equals("WHAT IS YOUR NAME") || givetext.equals("what is you name")) {
            output.setText("My name is memo! memo!! memorizes \n");
            input.setText("");
        } else if (givetext.equals("Who made you") || givetext.equals("who made you") || givetext.equals("WHO MADE YOU")) {
            output.setText("A lovable KIIIITIAN!!!\n");
            input.setText("");
        } else {
            output.setText("Sorry I can't understand.But I can search it.\n");

            try {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                String term = input.getText().toString();
                intent.putExtra(SearchManager.QUERY, term);
                startActivity(intent);
            } catch (Exception e) {
                output.setText("Sorry cant find\n");
                // TODO: handle exception


                //new lines

            }
        }

    }
}







