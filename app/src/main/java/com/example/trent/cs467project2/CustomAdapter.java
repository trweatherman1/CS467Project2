
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
 * Created by Trent on 3/18/2015.
*/
public class CustomAdapter extends ArrayAdapter<String> {
    private ArrayList<String> hand;

    private Context context;

    int viewSource;


    public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> dataItems) {
        super(context, textViewResourceId, dataItems);
        this.context = context;
        this.hand = dataItems;
        //this.hands = hands;
        viewSource = textViewResourceId;

    }

    public View getView(int position, View listItemView, ViewGroup parent) {
        View view = listItemView;

        if (view == null)//Only create if null - recycling a good idea
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(viewSource, parent, false);
        }

        String handText = this.hand.get(position);

        //Get the views from the list item XML
        TextView handPosition = (TextView) view.findViewById(R.id.textView3);
        // iButton = (TextView) view.findViewById(R.id.textView5);

        handPosition.setText(handText);

        return(view);
    }
}

