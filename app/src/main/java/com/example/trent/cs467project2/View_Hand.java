package com.example.trent.cs467project2;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class View_Hand extends ListActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        //setContentView(R.layout.activity_view__hand);
        String[] cards = new String[] { "250 Straight Flush", "100 Four of a Kind", "75 Full House",
                "50 Straight", "25 Three of a Kind", "10 Two Pair", "5 Pair" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cards);
        setListAdapter(adapter);



    }


    @Override
    public void onListItemClick(ListView l, View view, int position, long id) {
        TextView txt_v = (TextView) view;
        Toast.makeText(getApplicationContext(), ((TextView) view).getText(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }
}
