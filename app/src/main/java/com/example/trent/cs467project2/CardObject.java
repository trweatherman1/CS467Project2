package com.example.trent.cs467project2;

/**
 * @author Cody Pero and Trent Weatherman
 * @version 3/23/2015
 *
 * This file is used in correlation with a Poker Project for CS467
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
