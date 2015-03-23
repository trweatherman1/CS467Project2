package com.example.trent.cs467project2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class MainMenu extends Activity implements View.OnClickListener {

    Button button1, button2, button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);

        button1 = (Button) this.findViewById(R.id.button);
        button2 = (Button) this.findViewById(R.id.button2);
        button3 = (Button) this.findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        Intent option1 = new Intent(this, Player_Name.class);
        Intent option2 = new Intent(this, Play.class);
        Intent option3 = new Intent(this, View_Hand.class);

        if(v == button1){
            this.startActivity(option1);

        }
        else if(v == button2)
        {
            this.startActivity(option2);

        }
        else if(v == button3){
            this.startActivity(option3);
        }

    }
}
