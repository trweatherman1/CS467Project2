package com.example.trent.cs467project2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Trent on 3/22/2015.
 */
public class LargeWin extends Fragment {

    public LargeWin(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
            savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.activity_view_hand,
                container, false);
        return view;
    }


}
