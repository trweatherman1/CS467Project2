package com.example.trent.cs467project2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class Play extends Activity implements View.OnClickListener {

    Button menu_button, deal_button, win_button;
    ImageView image1, image2, image3, image4, image5;
    Boolean hold1, hold2, hold3, hold4, hold5;
    Button hold_button1, hold_button2, hold_button3, hold_button4, hold_button5;
    int play_counter, int_hand_counter, int_bank_counter, choice1, choice2, choice3, choice4, choice5;
    TextView hand_counter, bank_counter;
    String card1, card2, card3, card4, card5;
    CardObject[] cards;
    int total_bank, current_bank;
    TextView playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.small_screen);
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

        hand_counter = (TextView) this.findViewById(R.id.view_hands_counter);
        bank_counter = (TextView) this.findViewById(R.id.bank_counter);

        hand_counter.setText(int_hand_counter + "");
        bank_counter.setText(int_bank_counter + "");

        total_bank = 0;

        playerName = (TextView) this.findViewById(R.id.player_name);
        load();

        hold_button1.setVisibility(View.INVISIBLE);
        hold_button2.setVisibility(View.INVISIBLE);
        hold_button3.setVisibility(View.INVISIBLE);
        hold_button4.setVisibility(View.INVISIBLE);
        hold_button5.setVisibility(View.INVISIBLE);


    }

    @Override
    public void onClick(View v) {

        Intent option1 = new Intent(this, MainMenu.class);
        Intent option2 = new Intent(this, View_Hand.class);

        if (v == hold_button1) {
            hold1 = !hold1;
            if (hold1) {
                hold_button1.setText(R.string.hold);
            } else {
                hold_button1.setText(R.string.Throw);
            }

        }

        if (v == hold_button2) {

            hold2 = !hold2;
            if (hold2) {
                hold_button2.setText(R.string.hold);
            } else {
                hold_button2.setText(R.string.Throw);
            }

        }
        if (v == hold_button3) {

            hold3 = !hold3;
            if (hold3) {
                hold_button3.setText(R.string.hold);
            } else {
                hold_button3.setText(R.string.Throw);
            }

        }
        if (v == hold_button4) {

            hold4 = !hold4;
            if (hold4) {
                hold_button4.setText(R.string.hold);
            } else {
                hold_button4.setText(R.string.Throw);
            }

        }
        if (v == hold_button5) {

            hold5 = !hold5;
            if (hold5) {
                hold_button5.setText(R.string.hold);
            } else {
                hold_button5.setText(R.string.Throw);
            }

        }

        if (v == deal_button) {
            dealHelp();
        }

        if (v == menu_button) {
            this.startActivity(option1);
        }

        if (v == win_button) {
            this.startActivity(option2);
        }
    }

    private void dealHelp() {
        image1 = (ImageView) findViewById(R.id.card1);
        image2 = (ImageView) findViewById(R.id.card2);
        image3 = (ImageView) findViewById(R.id.card3);
        image4 = (ImageView) findViewById(R.id.card4);
        image5 = (ImageView) findViewById(R.id.card5);

        hold_button1.setVisibility(View.VISIBLE);
        hold_button2.setVisibility(View.VISIBLE);
        hold_button3.setVisibility(View.VISIBLE);
        hold_button4.setVisibility(View.VISIBLE);
        hold_button5.setVisibility(View.VISIBLE);

        TypedArray images = getResources().obtainTypedArray(R.array.random_card);
        int_hand_counter++;

        if (!hold1) {
            choice1 = (int) (Math.random() * images.length());
            image1.setImageResource(images.getResourceId(choice1, R.drawable.ace_of_clubs));
            card1 = images.getString(choice1);
        }
        if (!hold2) {
            choice2 = (int) (Math.random() * images.length());
            while (choice2 == choice1) {
                choice2 = (int) (Math.random() * images.length());
            }
            image2.setImageResource(images.getResourceId(choice2, R.drawable.ace_of_clubs));
            card2 = images.getString(choice2);
        }
        if (!hold3) {
            choice3 = (int) (Math.random() * images.length());
            while (choice3 == choice1 || choice3 == choice2) {
                choice3 = (int) (Math.random() * images.length());
            }
            image3.setImageResource(images.getResourceId(choice3, R.drawable.ace_of_clubs));
            card3 = images.getString(choice3);
        }
        if (!hold4) {
            choice4 = (int) (Math.random() * images.length());
            while (choice4 == choice1 || choice4 == choice2 || choice4 == choice3) {
                choice4 = (int) (Math.random() * images.length());
            }
            image4.setImageResource(images.getResourceId(choice4, R.drawable.ace_of_clubs));
            card4 = images.getString(choice4);
        }
        if (!hold5) {
            choice5 = (int) (Math.random() * images.length());
            while (choice5 == choice1 || choice5 == choice2 || choice5 == choice3 ||
                    choice5 == choice4) {
                choice5 = (int) (Math.random() * images.length());
            }
            image5.setImageResource(images.getResourceId(choice5, R.drawable.ace_of_clubs));
            card5 = images.getString(choice5);
        }
        images.recycle();
        play_counter++;
        hand_counter.setText(int_hand_counter + "");
        hold1 = false;
        hold2 = false;
        hold3 = false;
        hold4 = false;
        hold5 = false;

        hold_button1.setText(R.string.Throw);
        hold_button2.setText(R.string.Throw);
        hold_button3.setText(R.string.Throw);
        hold_button4.setText(R.string.Throw);
        hold_button5.setText(R.string.Throw);


        if (play_counter == 2) {
            play_counter = 0;
            getWinner();
        }
    }

    private void getWinner() {
        getCardNames();
        sortByRank();
        if (checkRoyalFlush()) {
            current_bank = 1000;
            displayDialog("You won $1000 with a Royal Flush!");
        } else if (checkStraightFlush()) {
            current_bank = 250;
            displayDialog("You won $250 with a Straight Flush!");
        } else if (checkFourOfAKind()) {
            current_bank = 100;
            displayDialog("You won $100 with 4 of a Kind!");
        } else if (checkFullHouse()) {
            current_bank = 50;
            displayDialog("You won $50 with a Full House!");
        } else if (checkFlush()) {
            current_bank = 30;
            displayDialog("You won $30 with a Flush!");
        } else if (checkStraight()) {
            current_bank = 25;
            displayDialog("You won $25 with a Straight!");
        } else if (checkThreeOfAKind()) {
            current_bank = 20;
            displayDialog("You won $20 with 3 of a Kind!");
        } else if (checkTwoPair()) {
            current_bank = 10;
            displayDialog("You won $10 with Two Pair!");
        } else if (checkPair()) {
            current_bank = 5;
            displayDialog("You won $5 with a Pair!");
        } else {
            current_bank = 0;
            displayDialog("Sorry, you lost!");
        }

        total_bank += current_bank;
        bank_counter.setText(total_bank + "");
    }

    private void getCardNames() {
        int length;
        card1 = card1.substring(22);
        length = card1.length();
        card1 = card1.substring(0, (length - 4));
        card2 = card2.substring(22);
        length = card2.length();
        card2 = card2.substring(0, (length - 4));
        card3 = card3.substring(22);
        length = card3.length();
        card3 = card3.substring(0, (length - 4));
        card4 = card4.substring(22);
        length = card4.length();
        card4 = card4.substring(0, (length - 4));
        card5 = card5.substring(22);
        length = card5.length();
        card5 = card5.substring(0, (length - 4));
        String card1_face = card1.substring(0, 2);
        String card2_face = card2.substring(0, 2);
        String card3_face = card3.substring(0, 2);
        String card4_face = card4.substring(0, 2);
        String card5_face = card5.substring(0, 2);
        length = card1.length();
        String card1_suit = card1.substring(length - 2, length);
        length = card2.length();
        String card2_suit = card2.substring(length - 2, length);
        length = card3.length();
        String card3_suit = card3.substring(length - 2, length);
        length = card4.length();
        String card4_suit = card4.substring(length - 2, length);
        length = card5.length();
        String card5_suit = card5.substring(length - 2, length);
        cards = new CardObject[5];

        cards[0] = new CardObject(getFace(card1_face), getSuit(card1_suit));
        cards[1] = new CardObject(getFace(card2_face), getSuit(card2_suit));
        cards[2] = new CardObject(getFace(card3_face), getSuit(card3_suit));
        cards[3] = new CardObject(getFace(card4_face), getSuit(card4_suit));
        cards[4] = new CardObject(getFace(card5_face), getSuit(card5_suit));
    }

    private int getFace(String string) {
        int face;
        if (string.equals("ac")) {
            face = Face.ACE.getRank();
            return face;
        }
        if (string.equals("c1")) {
            face = Face.TEN.getRank();
            return face;
        }
        if (string.equals("c2")) {
            face = Face.DUECE.getRank();
            return face;
        }
        if (string.equals("c3")) {
            face = Face.THREE.getRank();
            return face;
        }
        if (string.equals("c4")) {
            face = Face.FOUR.getRank();
            return face;
        }
        if (string.equals("c5")) {
            face = Face.FIVE.getRank();
            return face;
        }
        if (string.equals("c6")) {
            face = Face.SIX.getRank();
            return face;
        }
        if (string.equals("c7")) {
            face = Face.SEVEN.getRank();
            return face;
        }
        if (string.equals("c8")) {
            face = Face.EIGHT.getRank();
            return face;
        }
        if (string.equals("c9")) {
            face = Face.NINE.getRank();
            return face;
        }
        if (string.equals("ja")) {
            face = Face.JACK.getRank();
            return face;
        }
        if (string.equals("ki")) {
            face = Face.KING.getRank();
            return face;
        }
        if (string.equals("qu")) {
            face = Face.QUEEN.getRank();
            return face;
        }
        return 0;
    }

    private String getSuit(String string) {
        String suit;
        if (string.equals("bs")) {
            suit = Suit.CLUBS.getName();
            return suit;
        }
        if (string.equals("ds")) {
            suit = Suit.DIAMONDS.getName();
            return suit;
        }
        if (string.equals("ts")) {
            suit = Suit.HEARTS.getName();
            return suit;
        }
        if (string.equals("es")) {
            suit = Suit.SPADES.getName();
            return suit;
        }
        return null;
    }

    private void sortByRank() {
        CardObject temp_card;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int counter = 0; counter < cards.length - 1; counter++) {
                if (cards[counter].getRank() > cards[counter + 1].getRank()) {
                    temp_card = cards[counter];
                    cards[counter] = cards[counter + 1];
                    cards[counter + 1] = temp_card;
                    swapped = true;
                }
            }
        }
    }


    private boolean checkRoyalFlush() {
        String suit = cards[0].getSuit();
        int counter = 0;
        boolean isTrue = true;
        while (isTrue && counter < cards.length) {
            if (suit.equals(cards[counter].getSuit())) {
                isTrue = true;
            } else {
                isTrue = false;
            }
            counter++;
        }
        if (isTrue) {
            if (cards[0].getRank() != 1)
                return false;
            if (cards[1].getRank() != 10)
                return false;
            if (cards[2].getRank() != 11)
                return false;
            if (cards[3].getRank() != 12)
                return false;
            if (cards[4].getRank() != 13)
                return false;
        }
        return isTrue;
    }

    private boolean checkStraightFlush() {
        int i, testRank;
        boolean checkSuit = true;
        int counter = 0;
        String suit = cards[0].getSuit();

        while (checkSuit && counter < cards.length) {
            if (suit.equals(cards[counter].getSuit())) {
                checkSuit = true;
            } else {
                checkSuit = false;
            }
            counter++;
        }
        if (cards[0].getRank() == 1) {
            boolean a = cards[1].getRank() == 2 && cards[2].getRank() == 3 &&
                    cards[3].getRank() == 4 && cards[4].getRank() == 5;
            boolean b = cards[1].getRank() == 10 && cards[2].getRank() == 11 &&
                    cards[3].getRank() == 12 && cards[4].getRank() == 13;

            return (a || b);
        } else {

            testRank = cards[0].getRank() + 1;

            for (i = 1; i < 5; i++) {
                if (cards[i].getRank() != testRank)
                    return false;

                testRank++;
            }

            return true;
        }
    }

    private boolean checkFourOfAKind() {

        boolean match_1, match_2;

        match_1 = cards[0].getRank() == cards[1].getRank() &&
                cards[1].getRank() == cards[2].getRank() &&
                cards[2].getRank() == cards[3].getRank();

        match_2 = cards[1].getRank() == cards[2].getRank() &&
                cards[2].getRank() == cards[3].getRank() &&
                cards[3].getRank() == cards[4].getRank();

        return (match_1 || match_2);
    }

    private boolean checkFullHouse() {
        boolean match_1, match_2;

      /* ------------------------------------------------------
         Check for: x x x y y
	 ------------------------------------------------------- */
        match_1 = cards[0].getRank() == cards[1].getRank() &&
                cards[1].getRank() == cards[2].getRank() &&
                cards[3].getRank() == cards[4].getRank();

      /* ------------------------------------------------------
         Check for: x x y y y
	 ------------------------------------------------------- */
        match_2 = cards[0].getRank() == cards[1].getRank() &&
                cards[2].getRank() == cards[3].getRank() &&
                cards[3].getRank() == cards[4].getRank();

        return (match_1 || match_2);
    }

    private boolean checkStraight() {
        int i, testRank;
        if (cards[0].getRank() == 1) {
            boolean a = cards[1].getRank() == 2 && cards[2].getRank() == 3 &&
                    cards[3].getRank() == 4 && cards[4].getRank() == 5;
            boolean b = cards[1].getRank() == 10 && cards[2].getRank() == 11 &&
                    cards[3].getRank() == 12 && cards[4].getRank() == 13;

            return (a || b);
        } else {

            testRank = cards[0].getRank() + 1;

            for (i = 1; i < 5; i++) {
                if (cards[i].getRank() != testRank)
                    return false;

                testRank++;
            }

            return true;
        }
    }

    private boolean checkFlush() {
        boolean checkSuit = true;
        int counter = 0;
        String suit = cards[0].getSuit();

        while (checkSuit && counter < cards.length) {
            if (suit.equals(cards[counter].getSuit())) {
                checkSuit = true;
            } else {
                checkSuit = false;
            }
            counter++;
        }
        return checkSuit;
    }

    private boolean checkThreeOfAKind() {
        boolean match_1, match_2, match_3;
        match_1 = cards[0].getRank() == cards[1].getRank() &&
                cards[1].getRank() == cards[2].getRank() &&
                cards[3].getRank() != cards[0].getRank() &&
                cards[4].getRank() != cards[0].getRank() &&
                cards[3].getRank() != cards[4].getRank();
        match_2 = cards[1].getRank() == cards[2].getRank() &&
                cards[2].getRank() == cards[3].getRank() &&
                cards[0].getRank() != cards[1].getRank() &&
                cards[4].getRank() != cards[1].getRank() &&
                cards[0].getRank() != cards[4].getRank();
        match_3 = cards[2].getRank() == cards[3].getRank() &&
                cards[3].getRank() == cards[4].getRank() &&
                cards[0].getRank() != cards[2].getRank() &&
                cards[1].getRank() != cards[2].getRank() &&
                cards[0].getRank() != cards[1].getRank();

        return (match_1 || match_2 || match_3);
    }

    private boolean checkTwoPair() {
        boolean match_1, match_2, match_3;
        match_1 = cards[0].getRank() == cards[1].getRank() &&
                cards[2].getRank() == cards[3].getRank();
        match_2 = cards[0].getRank() == cards[1].getRank() &&
                cards[3].getRank() == cards[4].getRank();
        match_3 = cards[1].getRank() == cards[2].getRank() &&
                cards[3].getRank() == cards[4].getRank();
        return (match_1 || match_2 || match_3);
    }

    private boolean checkPair() {
        boolean match_1, match_2, match_3, match_4;

        match_1 = cards[0].getRank() == cards[1].getRank();
        match_2 = cards[1].getRank() == cards[2].getRank();
        match_3 = cards[2].getRank() == cards[3].getRank();
        match_4 = cards[3].getRank() == cards[4].getRank();
        return (match_1 || match_2 || match_3 || match_4);
    }

    private void displayDialog(String string) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(string + " Play again?");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        image1.setImageResource(R.drawable.back);
                        image2.setImageResource(R.drawable.back);
                        image3.setImageResource(R.drawable.back);
                        image4.setImageResource(R.drawable.back);
                        image5.setImageResource(R.drawable.back);

                        hold_button1.setVisibility(View.INVISIBLE);
                        hold_button2.setVisibility(View.INVISIBLE);
                        hold_button3.setVisibility(View.INVISIBLE);
                        hold_button4.setVisibility(View.INVISIBLE);
                        hold_button5.setVisibility(View.INVISIBLE);
                    }
                });
        builder1.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void load() {
        SharedPreferences settings = getSharedPreferences(AppHand.PREFS, Context.MODE_PRIVATE);
        String name = settings.getString(AppHand.NAME, "No Name");
        playerName.setText(name);
    }
}
