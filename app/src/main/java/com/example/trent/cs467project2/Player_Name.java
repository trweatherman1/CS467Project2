package com.example.trent.cs467project2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Cody Pero and Trent Weatherman
 * @version 3/23/2015
 *
 * This file is used in correlation with a Poker Project for CS467
 */

public class Player_Name extends Activity implements View.OnClickListener {
    Button submit;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_player__name);

        editText1 = (EditText) findViewById(R.id.editText);

        submit = (Button) this.findViewById(R.id.button4);
        submit.setOnClickListener(this);
        restore(savedInstanceState);
    }


    private void restore(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            String name = savedInstanceState.getString(AppHand.NAME, "");
            editText1.setText(name);


        }
    }

    /*
    public void load(){
        SharedPreferences settings = getSharedPreferences(AppHand.PREFS,Context.MODE_PRIVATE);
        String name = settings.getString(AppHand.NAME, "No Name");
        editText1.setText(name);
    }
    */

    public void submit() {
        SharedPreferences settings = getSharedPreferences(AppHand.PREFS,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String name = editText1.getText().toString();
        editor.putString(AppHand.NAME, name);
        editor.commit();
        Toast.makeText(getApplicationContext(), "Saved Player Name", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            // Always call the superclass so it can restore the view hierarchy
            super.onRestoreInstanceState(savedInstanceState);

            //store booking name
            String name = editText1.getText().toString();
            savedInstanceState.putString(AppHand.NAME,name);

        }
    }


    @Override
    public void onClick(View v) {
        //Intent intent = new Intent(this, MainMenu.class);

        if( v == submit){
            submit();
            //load();
            Intent intent = new Intent(this, MainMenu.class);
            this.startActivity(intent);
            finish();

        }
    }

}

