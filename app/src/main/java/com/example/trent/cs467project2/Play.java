package com.example.trent.cs467project2;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Play extends Activity implements View.OnClickListener {

    Button menu_button, deal_button, win_button;
    ImageView image1, image2, image3, image4, image5;
    Boolean hold1, hold2, hold3, hold4, hold5;
    Button hold_button1, hold_button2, hold_button3, hold_button4, hold_button5;
    int play_counter, int_hand_counter, int_bank_counter;
    TextView hand_counter, bank_counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_play);
        new Thread(new Runnable() {
            public void run() {
                image1 = (ImageView) findViewById(R.id.card1);
                image1.setImageResource(R.drawable.back);
                image2 = (ImageView) findViewById(R.id.card2);
                image2.setImageResource(R.drawable.back);
                image3 = (ImageView) findViewById(R.id.card3);
                image3.setImageResource(R.drawable.back);
                image4 = (ImageView) findViewById(R.id.card4);
                image4.setImageResource(R.drawable.back);
                image5 = (ImageView) findViewById(R.id.card5);
                image5.setImageResource(R.drawable.back);
            }
        }).start();
        hold1 = false;
        hold2 = false;
        hold3 = false;
        hold4 = false;
        hold5 = false;

        menu_button = (Button) this.findViewById(R.id.menu_button);
        deal_button = (Button) this.findViewById(R.id.deal_button);
        win_button = (Button) this.findViewById(R.id.win_button);

        menu_button.setOnClickListener(this);
        deal_button.setOnClickListener(this);
        win_button.setOnClickListener(this);

        hold_button1 = (Button) this.findViewById(R.id.hold_button1);
        hold_button2 = (Button) this.findViewById(R.id.hold_button2);
        hold_button3 = (Button) this.findViewById(R.id.hold_button3);
        hold_button4 = (Button) this.findViewById(R.id.hold_button4);
        hold_button5 = (Button) this.findViewById(R.id.hold_button5);

        hold_button1.setOnClickListener(this);
        hold_button2.setOnClickListener(this);
        hold_button3.setOnClickListener(this);
        hold_button4.setOnClickListener(this);
        hold_button5.setOnClickListener(this);

        play_counter = 0;
        int_hand_counter = 0;
        int_bank_counter = 0;

        hand_counter = (TextView)this.findViewById(R.id.view_hands_counter);
        bank_counter = (TextView)this.findViewById(R.id.bank_counter);

        hand_counter.setText(int_hand_counter + "");
        bank_counter.setText(int_bank_counter + "");
    }

    @Override
    public void onClick(View v) {

        if (v == hold_button1) {
            if (play_counter == 0) {
                Toast.makeText(getApplicationContext(),
                        "Please press deal first", Toast.LENGTH_LONG).show();
            } else {
                hold1 = !hold1;
            }
        }

        if (v == hold_button2) {
            if (play_counter == 0) {
                Toast.makeText(getApplicationContext(),
                        "Please press deal first", Toast.LENGTH_LONG).show();
            } else {
                hold2 = !hold2;
            }
        }
        if (v == hold_button3) {
            if (play_counter == 0) {
                Toast.makeText(getApplicationContext(),
                        "Please press deal first", Toast.LENGTH_LONG).show();
            } else {
                hold3 = !hold3;
            }
        }
        if (v == hold_button4) {
            if (play_counter == 0) {
                Toast.makeText(getApplicationContext(),
                        "Please press deal first", Toast.LENGTH_LONG).show();
            } else {
                hold4 = !hold4;
            }
        }
        if (v == hold_button5) {
            if (play_counter == 0) {
                Toast.makeText(getApplicationContext(),
                        "Please press deal first", Toast.LENGTH_LONG).show();
            } else {
                hold5 = !hold5;
            }
        }

        if (v == deal_button) {
            dealHelp();
        }
    }

    private void dealHelp() {
        image1 = (ImageView) findViewById(R.id.card1);
        image2 = (ImageView) findViewById(R.id.card2);
        image3 = (ImageView) findViewById(R.id.card3);
        image4 = (ImageView) findViewById(R.id.card4);
        image5 = (ImageView) findViewById(R.id.card5);

        TypedArray images = getResources().obtainTypedArray(R.array.random_card);
        int_hand_counter++;

        if (!hold1) {
            int choice = (int) (Math.random() * images.length());
            image1.setImageResource(images.getResourceId(choice, R.drawable.ace_of_clubs));
        }
        if (!hold2) {
            int choice2 = (int) (Math.random() * images.length());
            image2.setImageResource(images.getResourceId(choice2, R.drawable.ace_of_clubs));
        }
        if (!hold3) {
            int choice3 = (int) (Math.random() * images.length());
            image3.setImageResource(images.getResourceId(choice3, R.drawable.ace_of_clubs));
        }
        if (!hold4) {
            int choice4 = (int) (Math.random() * images.length());
            image4.setImageResource(images.getResourceId(choice4, R.drawable.ace_of_clubs));
        }
        if (!hold5) {
            int choice5 = (int) (Math.random() * images.length());
            image5.setImageResource(images.getResourceId(choice5, R.drawable.ace_of_clubs));
        }
        images.recycle();
        play_counter++;
        hand_counter.setText(int_hand_counter + "");

        if (play_counter == 2) {
            Toast.makeText(getApplicationContext(), "Good Game!", Toast.LENGTH_LONG).show();
            play_counter = 0;
            hold1 = false;
            hold2 = false;
            hold3 = false;
            hold4 = false;
            hold5 = false;
        }
    }
}
