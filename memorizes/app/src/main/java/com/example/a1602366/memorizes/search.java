package com.example.a1602366.memorizes;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 1602366 on 5/1/2018.
 */

public class search extends Activity  {
    EditText editText;
   @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

    }

        public void onSearchClick(View v)
        {
            editText=(EditText) findViewById(R.id.editText);

            try {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                String term = editText.getText().toString();
                intent.putExtra(SearchManager.QUERY, term);
                startActivity(intent);
            } catch (Exception e) {
                editText.setText("Sorry cant find");
                // TODO: handle exception
            }

        }




}


