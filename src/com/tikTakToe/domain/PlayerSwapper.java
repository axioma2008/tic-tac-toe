package com.tikTakToe.domain;

public class PlayerSwapper {
    public static char currentPlayer = 'x';

    public static void swapPlayer(){
        if (currentPlayer == 'x') {
            currentPlayer = 'o';
        } else {
            currentPlayer = 'x';
        }

    }

}
