package com.example.trent.cs467project2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;


public class Splash extends Activity {

    ProgressBar progressBar; //ProgressBar that displays on the screen
    android.os.Handler handler; //The handler for the activity
    static final int DELAY = 5000; //Determine how long to pause on splash
    Class nextActivity = MainMenu.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = (ProgressBar)this.findViewById(R.id.progressBar);

    }

    public void onStart(){
        super.onStart();
        handler = new android.os.Handler();
        handler.postDelayed(r, DELAY);
    }

    Runnable r = new Runnable() {
        public void run() {
            goToNextScreen();
        }
    };

    /**
     * Calls the next screen with an intent
     */
    public void goToNextScreen(){
        Intent nextScreen = new Intent(this, nextActivity);
        this.startActivity(nextScreen);
        finish();

    }
}
