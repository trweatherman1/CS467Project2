package com.example.trent.cs467project2;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


public class WinList extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //setContentView(R.layout.activity_win_list);


            Bundle extraIntents = getIntent().getExtras();
            String royal = extraIntents.getString(AppHand.ROYAL);
            if (royal != null) {
                setContentView(R.layout.royal_flush);
            }
            String straightFlush = extraIntents.getString(AppHand.STRAIGHTFLUSH);
            if (straightFlush != null) {
                setContentView(R.layout.straight);
            }
            String fourOfKind = extraIntents.getString(AppHand.FOUROFAKIND);
            if (fourOfKind != null) {
                setContentView(R.layout.four_of_a_kind);

            }
            String fullHouse = extraIntents.getString(AppHand.FULLHOUSE);
            if (fullHouse != null) {
                setContentView(R.layout.full_house);
            }
            String flush = extraIntents.getString(AppHand.FLUSH);
            if (flush != null) {
                setContentView(R.layout.flush);
            }
            String straightHand = extraIntents.getString(AppHand.STRAIGHTHAND);
            if (straightHand != null) {
                setContentView(R.layout.straight_hand);
            }
            String threeOfKind = extraIntents.getString(AppHand.THREEOFAKIND);
            if (threeOfKind != null) {
                setContentView(R.layout.three_of_a_kind);
            }
            String twoPair = extraIntents.getString(AppHand.TWOPAIR);
            if (twoPair != null) {
                setContentView(R.layout.two_pair);
            }
            String pair = extraIntents.getString(AppHand.PAIR);
            if (pair != null) {
                setContentView(R.layout.pair);
            }

    }


}
