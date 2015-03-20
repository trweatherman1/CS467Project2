package com.example.trent.cs467project2;

import android.app.Activity;
import android.content.Intent;
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
    int play_counter, int_hand_counter, int_bank_counter, choice1, choice2, choice3, choice4, choice5;
    TextView hand_counter, bank_counter;
    String card1, card2, card3, card4, card5;
    Card[] cards;

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

        Intent option1 = new Intent(this, MainMenu.class);
        Intent option2 = new Intent(this, View_Hand.class);

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

        if(v == menu_button){
            this.startActivity(option1);
        }

        if(v== win_button){
            this.startActivity(option2);
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
            choice1 = (int) (Math.random() * images.length());
            image1.setImageResource(images.getResourceId(choice1, R.drawable.ace_of_clubs));
            card1 = images.getString(choice1);
        }
        if (!hold2) {
            choice2 = (int) (Math.random() * images.length());
            image2.setImageResource(images.getResourceId(choice2, R.drawable.ace_of_clubs));
            card2 = images.getString(choice2);
        }
        if (!hold3) {
            choice3 = (int) (Math.random() * images.length());
            image3.setImageResource(images.getResourceId(choice3, R.drawable.ace_of_clubs));
            card3 = images.getString(choice3);
        }
        if (!hold4) {
            choice4 = (int) (Math.random() * images.length());
            image4.setImageResource(images.getResourceId(choice4, R.drawable.ace_of_clubs));
            card4 = images.getString(choice4);
        }
        if (!hold5) {
            choice5 = (int) (Math.random() * images.length());
            image5.setImageResource(images.getResourceId(choice5, R.drawable.ace_of_clubs));
            card5 = images.getString(choice5);
        }
        images.recycle();
        play_counter++;
        hand_counter.setText(int_hand_counter + "");

        if (play_counter == 2) {
            //Toast.makeText(getApplicationContext(), "Good Game!", Toast.LENGTH_LONG).show();
            play_counter = 0;
            hold1 = false;
            hold2 = false;
            hold3 = false;
            hold4 = false;
            hold5 = false;
            getWinner();
        }
    }

    private void getWinner(){
        getCardNames();
        sortByRank();
        if(checkRoyalFlush() != null){
            //WE GOT A WINNER
        }
    }

    private void getCardNames(){
        int length = card1.length();
        card1 = card1.substring(22);
        card1 = card1.substring(0, length-4);
        card2 = card2.substring(22);
        card2 = card2.substring(0, length-4);
        card3 = card3.substring(22);
        card3 = card3.substring(0, length-4);
        card4 = card4.substring(22);
        card4 = card4.substring(0, length-4);
        card5 = card5.substring(22);
        card5 = card5.substring(0, length-4);
        String card1_face = card1.substring(0,2);
        String card2_face = card2.substring(0,2);
        String card3_face = card3.substring(0,2);
        String card4_face = card4.substring(0,2);
        String card5_face = card5.substring(0,2);
        length = card1.length();
        String card1_suit = card1.substring(length-2, length);
        length = card2.length();
        String card2_suit = card2.substring(length-2, length);
        length = card3.length();
        String card3_suit = card3.substring(length-2, length);
        length = card4.length();
        String card4_suit = card4.substring(length-2, length);
        length = card5.length();
        String card5_suit = card5.substring(length-2, length);
        cards = new Card[5];
        cards[0] = new Card(getFace(card1_face), getSuit(card1_suit));
        cards[1] = new Card(getFace(card2_face), getSuit(card2_suit));
        cards[2] = new Card(getFace(card3_face), getSuit(card3_suit));
        cards[3] = new Card(getFace(card4_face), getSuit(card4_suit));
        cards[4] = new Card(getFace(card5_face), getSuit(card5_suit));
    }

    private Face getFace(String string){
        if (string.equals("ac")){
            return Face.ACE;
        }
        if (string.equals("c1")){
            return Face.TEN;
        }
        if (string.equals("c2")){
            return Face.DUECE;
        }
        if (string.equals("c3")){
            return Face.THREE;
        }
        if (string.equals("c4")){
            return Face.FOUR;
        }
        if (string.equals("c5")){
            return Face.FIVE;
        }
        if (string.equals("c6")){
            return Face.SIX;
        }
        if (string.equals("c7")){
            return Face.SEVEN;
        }
        if (string.equals("c8")){
            return Face.EIGHT;
        }
        if (string.equals("c9")){
            return Face.NINE;
        }
        if (string.equals("ja")){
            return Face.JACK;
        }
        if (string.equals("ki")){
            return Face.KING;
        }
        if (string.equals("qu")){
            return Face.QUEEN;
        }
        return null;
    }

    private Suit getSuit(String string){
        if (string.equals("bs")){
            return Suit.CLUBS;
        }
        if (string.equals("ds")){
            return Suit.DIAMONDS;
        }
        if (string.equals("ts")){
            return Suit.HEARTS;
        }
        if (string.equals("es")){
            return Suit.SPADES;
        }
        return null;
    }

    private void sortByRank(){
        Card temp_card;
        boolean swapped = true;
        while(swapped) {
            swapped = false;
            for (int counter = 0; counter < cards.length; counter++) {
                if (cards[counter].getName().getRank() > cards[counter + 1].getName().getRank()) {
                    temp_card = cards[counter];
                    cards[counter] = cards[counter + 1];
                    cards[counter + 1] = temp_card;
                    swapped = true;
                }
            }
        }
    }

    private WinHand checkRoyalFlush(){
        Card temp_card = cards[0];
        boolean isRoyalFlush = true;
        for(int counter = 0; counter < cards.length && isRoyalFlush; counter++) {
            if(!temp_card.getSuit().equals(cards[counter].getSuit())){
                isRoyalFlush = false;
            }
        }
        if(isRoyalFlush){
            for(int counter = 0; counter < cards.length && isRoyalFlush; counter++){
                if (cards[counter].getName().getRank() == cards[counter + 1].getName().getRank()){
                    isRoyalFlush = true;
                }
                else{
                    isRoyalFlush = false;
                }
            }
        }
        if(isRoyalFlush)
            return WinHand.RFLUSH;
        else
            return null;
    }

    private WinHand checkStraightFlush(){

    }
    private WinHand checkFourOfAKind(){

    }
    private WinHand checkFullHouse(){

    }
    private WinHand checkStraightFlush(){

    }
    private WinHand checkThreeOfAKind(){

    }
    private WinHand checkTwoPair(){

    }
    private WinHand checkPair(){

    }
}
