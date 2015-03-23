package com.example.trent.cs467project2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Cody Pero and Trent Weatherman
 * @version 3/23/2015
 *
 * This file is used in correlation with a Poker Project for CS467
 */

public class SmallScreen extends Fragment {

    public SmallScreen(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
            savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.activity_play,
                container, false);
        return view;
    }

}
