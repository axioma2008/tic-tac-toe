package com.tikTakToe.visualizer;

public class Board {
    private int width;
    private int height;
    private char[][] myBoard;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        myBoard = new char[height][width];

        initBoard();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMyBoard() {
        return myBoard;
    }

    private void initBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                myBoard[i][j] = '-';
            }
        }
    }


}
