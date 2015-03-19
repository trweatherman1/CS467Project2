package com.example.trent.cs467project2;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

/*
public class WinList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_win_list);

        Bundle extraIntents = getIntent().getExtras();
        String royal = extraIntents.getString();
        if(rf != null){
            setContentView(R.layout.royal_flush);
        }
        String straightFlush = extraIntents.getString();
        if(straightFlush != null){
            setContentView(R.layout.straight);
        }
        String fourOfkind = extraIntents.getString(AppValues.FOUROFAKIND);
        if (fourOfkind != null) {
            setContentView(R.layout.four_of_a_kind);
        }
        String fullHouse = extraIntents.getString(AppValues.FULLHOUSE);
        if (fullHouse != null) {
            setContentView(R.layout.full_house);
        }
        String flush = extraIntents.getString(AppValues.FLUSH);
        if (flush != null) {
            setContentView(R.layout.flush);
        }
        String straightHand = extraIntents.getString(AppValues.STRAIGHTHAND);
        if (straightHand != null) {
            setContentView(R.layout.straight_hand);
        }
        String threeOfKind = extraIntents.getString(AppValues.THREEOFAKIND);
        if (threeOfKind != null) {
            setContentView(R.layout.three_of_a_kind);
        }
        String twoPair = extraIntents.getString(AppValues.TWOPAIR);
        if (twoPair != null) {
            setContentView(R.layout.two_pair);
        }
        String pair = extraIntents.getString(AppValues.PAIR);
        if (pair != null) {
            setContentView(R.layout.pair);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_win_list, menu);
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
*/