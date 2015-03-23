
package com.example.trent.cs467project2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Cody Pero and Trent Weatherman
 * @version 3/23/2015
 *
 * This file is used in correlation with a Poker Project for CS467
 */

public class CustomAdapter extends ArrayAdapter<String> {
    private ArrayList<String> hands;

    private Context context;

    int viewSource;


    public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> dataItems) {
        super(context, textViewResourceId, dataItems);
        this.context = context;
        this.hands= dataItems;
        //this.hands = hands;
        viewSource = textViewResourceId;

    }

    public View getView(int position, View listItemView, ViewGroup parent) {
        View view = listItemView;

        if (view == null)//Only create if null - recycling a good idea
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(viewSource, parent, false);
        }

        //String valueText = this.values.get(position);
        String handText = this.hands.get(position);

        //Get the views from the list item XML
        TextView handPosition = (TextView) view.findViewById(R.id.textView3);
        //TextView valuePosition = (TextView) view.findViewById(R.id.textView4);

        //valuePosition.setText(valueText);
        handPosition.setText(handText);

        return(view);
    }
}

