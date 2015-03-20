package com.example.trent.cs467project2;

/**
 * Created by Cody on 3/20/2015.
 */
public class CardObject {

    private int rank;
    private String suit;

    public CardObject(int rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank(){
        return rank;
    }

    public String getSuit(){
        return suit;
    }
}
