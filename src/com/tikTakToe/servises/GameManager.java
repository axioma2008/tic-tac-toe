package com.tikTakToe.servises;


import com.tikTakToe.domain.GameSaver;
import com.tikTakToe.domain.GameStarter;
import com.tikTakToe.domain.SettingsHolder;

public class GameManager {
    private int width = 3;
    private int height = 3;

    private SettingsHolder settingsHolder = new SettingsHolder();

    private GameStarter gameStarter = new GameStarter();


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void drawBoard(char[][] myBoard, int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(myBoard[i][j] + " ");
                if (j == width - 1) {
                    System.out.print("\n");
                }
            }
        }
    }

    public boolean checkMainDiagonal(char[][] myBoard, int width, int height) {
        if (width != height) {
            return false;
        }
        char container = 0;
        for (int i = 0; i < width; i++) {
            if (myBoard[i][i] == '-') {
                return false;
            }

            if (container == 0) {
                container = myBoard[i][i];
                continue;
            }
            if (container != myBoard[i][i]) {
                return false;
            }
            if (i == width - 1) {
                return true;
            }
        }
        return false;

    }

    public boolean checkOtherDiagonal(char[][] myBoard, int width, int height) {

        if (width != height) {
            return false;
        }
        char container = 0;
        for (int j = width - 1; j >= 0; j--) {
            if (myBoard[width - j - 1][j] == '-') {
                return false;
            }
            if (container == 0) {
                container = myBoard[width - j - 1][j];
                continue;
            }
            if (container != myBoard[width - j - 1][j]) {
                return false;
            }
            if (j == 0) {
                return true;

            }
        }

        return false;
    }

    public boolean checkRows(char[][] myBoard, int width, int height) {
        char container = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (myBoard[i][j] == '-') {
                    break;
                }
                if (container == 0) {
                    container = myBoard[i][j];
                    continue;
                }
                if (container != myBoard[i][j]) {
                    break;
                }
                if (j == width - 1) {
                    return true;
                }
            }
            container = 0;
        }

        return false;

    }


    public boolean checkColumns(char[][] myBoard, int width, int height) {
        char container = 0;
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                if (myBoard[i][j] == '-') {
                    break;
                }
                if (container == 0) {
                    container = myBoard[i][j];
                    continue;
                }
                if (container != myBoard[i][j]) {
                    break;
                }
                if (i == height - 1) {
                    return true;
                }
            }
            container = 0;
        }
        return false;
    }


    private void changeWidthAndHeight(int width, int height) {
        this.width = width;
        this.height = height;

    }

    public void gameStart() {
        gameStarter.startGame(width, height);

    }


    public void readSavedSettings() {
        if (settingsHolder.readSavedSettings().length != 1) {
            int[] widthAndHeight = settingsHolder.readSavedSettings();
            changeWidthAndHeight(widthAndHeight[0], widthAndHeight[1]);
        }

    }


    public void setSettings() {
        int[] widthAndHeight = settingsHolder.setSettings();
        changeWidthAndHeight(widthAndHeight[0], widthAndHeight[1]);
    }
}
