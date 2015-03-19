package com.example.trent.cs467project2;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;


public class Play extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_play);
        new Thread(new Runnable() {
            public void run() {
                ImageView image1 = (ImageView) findViewById(R.id.card1);
                image1.setImageResource(R.drawable.back);
                ImageView image2 = (ImageView) findViewById(R.id.card2);
                image2.setImageResource(R.drawable.back);
                ImageView image3 = (ImageView) findViewById(R.id.card3);
                image3.setImageResource(R.drawable.back);
                ImageView image4 = (ImageView) findViewById(R.id.card4);
                image4.setImageResource(R.drawable.back);
                ImageView image5 = (ImageView) findViewById(R.id.card5);
                image5.setImageResource(R.drawable.back);
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
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
}
