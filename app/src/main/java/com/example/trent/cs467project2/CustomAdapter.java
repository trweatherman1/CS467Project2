
package com.example.trent.cs467project2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Trent on 3/18/2015.
*/
public class CustomAdapter extends ArrayAdapter<String> {
    private ArrayList<String> amount;

    private ArrayList<Drawable> images;

    private Context context;

    int viewSource;


    public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> dataItems,
                         ArrayList<Drawable> images) {
        super(context, textViewResourceId, dataItems);
        this.context = context;
        this.amount = dataItems;
        this.images = images;
        viewSource = textViewResourceId;

    }

    public View getView(int position, View listItemView, ViewGroup parent) {
        View v = listItemView;

        //The views are recycled when off screen. For example if there were 100 list views
        //Android would quicky run out of memory if all of them were held in memory, instead
        //when a list view row drops of the screen it gets reused. That way data consumption
        //and processing time is at a minimum.
        //There is a further optimization that can be applied. By the means of an inner holding class
        //See ListView5 project for an example of this.


        if (v == null)//Only create if null - recycling a good idea
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(viewSource, parent, false);
        }

        String itemText = this.text.get(position);

        //Get the views from the list item XML
        TextView bTitle = (TextView) v.findViewById(R.id.textView4);
        TextView iButton = (TextView) v.findViewById(R.id.textView5);


    }
}

