package com.example.studentfeesmgt;


import android.content.Intent;
import android.os.Handler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
 private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        //hide action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



             new Handler(). postDelayed(new Runnable () {
         @Override
            public void run () {
             Intent homeIntent = new Intent(MainActivity.this, HomePage.class );
             startActivity (homeIntent);
             finish();

        }
    }, SPLASH_TIME_OUT);
}

}