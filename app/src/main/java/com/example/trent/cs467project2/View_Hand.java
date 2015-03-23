package com.example.trent.cs467project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trent.cs467project2.AppHand;
import com.example.trent.cs467project2.R;

import java.util.ArrayList;

/**
 * @author Cody Pero and Trent Weatherman
 * @version 3/23/2015
 *
 * This file is used in correlation with a Poker Project for CS467
 */

public class View_Hand extends Activity implements AdapterView.OnItemClickListener {

    private ArrayList<String> hands;

    private TextView hand;

    private ListView lvCard;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hand);

        hand = (TextView) this.findViewById(R.id.textView3);

        getListData();

        lvCard = (ListView) findViewById(R.id.listView);

        lvCard.setOnItemClickListener(this);

        adapter = new CustomAdapter(this, R.layout.list_item, hands);
        lvCard.setAdapter(adapter);

    }

    public void getListData() {

        hands = new ArrayList<String>();
        hands.add(getString(R.string.royal_flush));
        hands.add(getString(R.string.straight_flush));
        hands.add(getString(R.string.four_of_a_kind));
        hands.add(getString(R.string.full_house));
        hands.add(getString(R.string.flush));
        hands.add(getString(R.string.straight_hand));
        hands.add(getString(R.string.three_of_a_kind));
        hands.add(getString(R.string.two_pair));
        hands.add(getString(R.string.pair));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent;
        TextView text = (TextView) view.findViewById(R.id.textView3);
        String handName = text.getText().toString();
        switch (handName) {

            case AppHand.ROYAL:
                intent = new Intent(this, WinList.class);
                intent.putExtra(AppHand.ROYAL, handName);
                startActivity(intent);
                break;

            case AppHand.STRAIGHTFLUSH:
                intent = new Intent(this, WinList.class);
                intent.putExtra(AppHand.STRAIGHTFLUSH, handName);
                startActivity(intent);
                break;

            case AppHand.FOUROFAKIND:
                intent = new Intent(this, WinList.class);
                intent.putExtra(AppHand.FOUROFAKIND, handName);
                startActivity(intent);
                break;

            case AppHand.FULLHOUSE:
                intent = new Intent(this, WinList.class);
                intent.putExtra(AppHand.FULLHOUSE, handName);
                startActivity(intent);
                break;

            case AppHand.FLUSH:
                intent = new Intent(this, WinList.class);
                intent.putExtra(AppHand.FLUSH, handName);
                startActivity(intent);
                break;

            case AppHand.STRAIGHTHAND:
                intent = new Intent(this, WinList.class);
                intent.putExtra(AppHand.STRAIGHTHAND, handName);
                startActivity(intent);
                break;

            case AppHand.THREEOFAKIND:
                intent = new Intent(this, WinList.class);
                intent.putExtra(AppHand.THREEOFAKIND, handName);
                startActivity(intent);
                break;

            case AppHand.TWOPAIR:
                intent = new Intent(this, WinList.class);
                intent.putExtra(AppHand.TWOPAIR, handName);
                startActivity(intent);
                break;

            case AppHand.PAIR:
                intent = new Intent(this, WinList.class);
                intent.putExtra(AppHand.PAIR, handName);
                startActivity(intent);
                break;
        }
    }
}