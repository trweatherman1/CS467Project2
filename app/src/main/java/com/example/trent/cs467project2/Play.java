package com.example.trent.cs467project2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
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
    CardObject[] cards;
    EditText editText;

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

        editText = this.findViewById()
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
                if(hold1){
                    hold_button1.setText(R.string.hold);
                } else{
                    hold_button1.setText(R.string.Throw);
                }
            }
        }

        if (v == hold_button2) {
            if (play_counter == 0) {
                Toast.makeText(getApplicationContext(),
                        "Please press deal first", Toast.LENGTH_LONG).show();
            } else {
                hold2 = !hold2;
                if(hold2){
                    hold_button2.setText(R.string.hold);
                } else{
                    hold_button2.setText(R.string.Throw);
                }
            }
        }
        if (v == hold_button3) {
            if (play_counter == 0) {
                Toast.makeText(getApplicationContext(),
                        "Please press deal first", Toast.LENGTH_LONG).show();
            } else {
                hold3 = !hold3;
                if(hold3){
                    hold_button3.setText(R.string.hold);
                } else{
                    hold_button3.setText(R.string.Throw);
                }
            }
        }
        if (v == hold_button4) {
            if (play_counter == 0) {
                Toast.makeText(getApplicationContext(),
                        "Please press deal first", Toast.LENGTH_LONG).show();
            } else {
                hold4 = !hold4;
                if(hold4){
                    hold_button4.setText(R.string.hold);
                } else{
                    hold_button4.setText(R.string.Throw);
                }
            }
        }
        if (v == hold_button5) {
            if (play_counter == 0) {
                Toast.makeText(getApplicationContext(),
                        "Please press deal first", Toast.LENGTH_LONG).show();
            } else {
                hold5 = !hold5;
                if(hold5){
                    hold_button5.setText(R.string.hold);
                } else{
                    hold_button5.setText(R.string.Throw);
                }
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
        if(checkRoyalFlush()){
            Toast.makeText(this, "ROYAL FLUSH", Toast.LENGTH_SHORT).show();
        } else if(checkStraightFlush()) {
            Toast.makeText(this, "STRAIGHT FLUSH", Toast.LENGTH_SHORT).show();
        } else if(checkFourOfAKind()) {
            Toast.makeText(this, "FOUR OF A KIND", Toast.LENGTH_SHORT).show();
        } else if(checkFullHouse()) {
            Toast.makeText(this, "FULL HOUSE", Toast.LENGTH_SHORT).show();
        } else if(checkStraight()) {
            Toast.makeText(this, "STRAIGHT", Toast.LENGTH_SHORT).show();
        } else if(checkThreeOfAKind()) {
            Toast.makeText(this, "THREE OF A KIND", Toast.LENGTH_SHORT).show();
        } else if(checkTwoPair()) {
            Toast.makeText(this, "TWO PAIR", Toast.LENGTH_SHORT).show();
        } else if(checkPair()) {
            Toast.makeText(this, "PAIR", Toast.LENGTH_SHORT).show();
        }
    }

    private void getCardNames(){
        int length;
        card1 = card1.substring(22);
        length = card1.length();
        card1 = card1.substring(0, (length-4));
        card2 = card2.substring(22);
        length = card2.length();
        card2 = card2.substring(0, (length-4));
        card3 = card3.substring(22);
        length = card3.length();
        card3 = card3.substring(0, (length-4));
        card4 = card4.substring(22);
        length = card4.length();
        card4 = card4.substring(0, (length-4));
        card5 = card5.substring(22);
        length = card5.length();
        card5 = card5.substring(0, (length-4));
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
        cards = new CardObject[5];

        cards[0] = new CardObject(getFace(card1_face), getSuit(card1_suit));
        cards[1] = new CardObject(getFace(card2_face), getSuit(card2_suit));
        cards[2] = new CardObject(getFace(card3_face), getSuit(card3_suit));
        cards[3] = new CardObject(getFace(card4_face), getSuit(card4_suit));
        cards[4] = new CardObject(getFace(card5_face), getSuit(card5_suit));
    }

    private int getFace(String string){
        int face;
        if (string.equals("ac")){
            face = Face.ACE.getRank();
            return face;
        }
        if (string.equals("c1")){
            face = Face.TEN.getRank();
            return face;
        }
        if (string.equals("c2")){
            face = Face.DUECE.getRank();
            return face;
        }
        if (string.equals("c3")){
            face = Face.THREE.getRank();
            return face;
        }
        if (string.equals("c4")){
            face = Face.FOUR.getRank();
            return face;
        }
        if (string.equals("c5")){
            face = Face.FIVE.getRank();
            return face;
        }
        if (string.equals("c6")){
            face = Face.SIX.getRank();
            return face;
        }
        if (string.equals("c7")){
            face = Face.SEVEN.getRank();
            return face;
        }
        if (string.equals("c8")){
            face = Face.EIGHT.getRank();
            return face;
        }
        if (string.equals("c9")){
            face = Face.NINE.getRank();
            return face;
        }
        if (string.equals("ja")){
            face = Face.JACK.getRank();
            return face;
        }
        if (string.equals("ki")){
            face = Face.KING.getRank();
            return face;
        }
        if (string.equals("qu")){
            face = Face.QUEEN.getRank();
            return face;
        }
        return 0;
    }

    private String getSuit(String string){
        String suit;
        if (string.equals("bs")){
            suit = Suit.CLUBS.getName();
            return suit;
        }
        if (string.equals("ds")){
            suit = Suit.DIAMONDS.getName();
            return suit;
        }
        if (string.equals("ts")){
            suit = Suit.HEARTS.getName();
            return suit;
        }
        if (string.equals("es")){
            suit = Suit.SPADES.getName();
            return suit;
        }
        return null;
    }

    private void sortByRank(){
        CardObject temp_card;
        boolean swapped = true;
        while(swapped) {
            swapped = false;
            for (int counter = 0; counter < cards.length-1; counter++) {
                if (cards[counter].getRank() > cards[counter + 1].getRank()) {
                    temp_card = cards[counter];
                    cards[counter] = cards[counter + 1];
                    cards[counter + 1] = temp_card;
                    swapped = true;
                }
            }
        }
    }

    private boolean checkRoyalFlush(){
        String suit = cards[0].getSuit();
        int counter = 0;
        boolean isTrue = true;
        while(isTrue && counter < cards.length){
            if(suit.equals(cards[0].getSuit())){
                isTrue = true;
            }
            else {
                isTrue = false;
            }
        }
        if(isTrue){
            counter = 0;
            while (counter < (cards.length - 1) && isTrue){
                if(cards[counter+1].getRank() - cards[counter].getRank() != 1)
                    isTrue = false;
            }
        }
        if(isTrue){
            if(cards[0].getRank() != 1)
                isTrue = false;
            if(cards[1].getRank() != 10)
                isTrue = false;
            if(cards[2].getRank() != 11)
                isTrue = false;
            if(cards[3].getRank() != 12)
                isTrue = false;
            if(cards[4].getRank() != 13)
                isTrue = false;
        }
        return isTrue;
    }

    private boolean checkStraightFlush(){
        String suit = cards[0].getSuit();
        int counter = 0;
        boolean isTrue = true;
        while(isTrue && counter < cards.length){
            if(suit.equals(cards[0].getSuit())){
                isTrue = true;
            }
            else {
                isTrue = false;
            }
        }
        if(isTrue){
            counter = 0;
            while (counter < (cards.length - 1) && isTrue){
                if(cards[counter+1].getRank() - cards[counter].getRank() != 1)
                    isTrue = false;
            }
        }
        return isTrue;
    }

    private boolean checkFourOfAKind(){
        boolean isTrue = true;
        int num_match = 0;
        for(int counter = 0; counter < cards.length-1; counter++){
            if(cards[counter].getRank() == cards[counter+1].getRank())
                num_match++;
        }
        if(num_match != 4)
            isTrue = false;
        return isTrue;
    }
    private boolean checkFullHouse(){
        if(cards[0].getRank() == cards[1].getRank()){
            if(cards[2].getRank() == cards[3].getRank()){
                if(cards[3].getRank() == cards[4].getRank()){
                    return true;
                }
            }
            if(cards[1].getRank() == cards[2].getRank()){
                if(cards[3].getRank() == cards[4].getRank()){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkStraight(){
        int num_match = 0;
        for(int counter = 0; counter < cards.length; counter++){
            if(cards[0].getSuit().equals(cards[counter].getSuit()))
                num_match++;
        }
        if(num_match == 5)
            return true;
        return false;
    }
    private boolean checkThreeOfAKind(){
        int num_match = 0;
        for(int counter = 0; counter < cards.length; counter++){
            if(cards[0].getRank() == cards[counter].getRank()){
                num_match++;
            }
        }
        if(num_match == 3){
            return true;
        }
        else{
            for (int counter = 0; counter < cards.length; counter++){
                if(cards[1].getRank() == cards[counter].getRank()){
                    num_match++;
                }
            }
            if(num_match == 3){
                return true;
            }
            else {
                for (int counter = 0; counter < cards.length; counter++){
                    if(cards[2].getRank() == cards[counter].getRank()){
                        num_match++;
                    }
                }
                if(num_match == 3){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkTwoPair(){
        boolean match_1, match_2, match_3;
        match_1 = cards[0].getRank() == cards[1].getRank() &&
                cards[2].getRank() == cards[3].getRank() ;
        match_2 = cards[0].getRank() == cards[1].getRank() &&
                cards[3].getRank() == cards[4].getRank() ;
        match_3 = cards[1].getRank() ==cards[2].getRank() &&
                cards[3].getRank() ==cards[4].getRank() ;
        return( match_1 || match_2 || match_3 );
    }
    private boolean checkPair(){
        boolean match_1, match_2, match_3, match_4;
        match_1 = cards[0].getRank() == cards[1].getRank();
        match_2 = cards[1].getRank() == cards[2].getRank();
        match_3 = cards[2].getRank() == cards[3].getRank();
        match_4 = cards[3].getRank() == cards[4].getRank();
        return( match_1 || match_2 || match_3 || match_4 );
    }

    public void loadPrefs(){
        SharedPreferences settings = getSharedPreferences(AppHand.PREFS, Context.MODE_PRIVATE);
        String name = settings.getString(AppHand.NAME, "No Name");
        editText1.setText(name);
    }
}
