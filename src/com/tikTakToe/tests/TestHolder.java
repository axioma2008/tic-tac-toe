package com.tikTakToe.tests;

public class TestHolder {


    public void boardForTestRows(char[][] myBoard, int width) {
        int indexRow = (int)(Math.random() * width);
        for (int i = 0; i < width; i++) {
            myBoard[indexRow][i] = 'x';
        }
    }

    public void boardForTestColumns(char[][] myBoard, int height) {
        int indexColumn = (int)(Math.random() * height);
        for (int i = 0; i < height; i++) {
            myBoard[i][indexColumn] = 'x';
        }
    }

    public void boardForTestMainDiagonal(char[][] myBoard, int width, int height) {
        if (width == height){
            for (int i = 0; i < width; i++) {
                myBoard[i][i] = 'x';
            }
        }
        else{
            System.out.println("Разное количество строк и столбцов");
        }
    }

    public void boardForTestOtherDiagonal(char[][] myBoard, int width, int height) {
        if (width == height){
            for (int i = 0; i < width; i++) {
                myBoard[i][width - i - 1] = 'x';
            }
        }
        else{
            System.out.println("Разное количество строк и столбцов");
        }
    }
}
