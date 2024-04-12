package com.tikTakToe.domain;

import com.tikTakToe.servises.GameManager;
import com.tikTakToe.servises.PatternChecker;
import com.tikTakToe.tests.TestHolder;
import com.tikTakToe.visualizer.Board;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class GameStarter {


    public void startGame(int width, int height) {
        boolean isGameFinish = false;

        GameManager gameManager = new GameManager();

        Board board = new Board(width, height);
        Scanner scanner = new Scanner(System.in);
        GameSaver gameSaver = new GameSaver();


        gameManager.drawBoard(board.getMyBoard(), board.getWidth(), board.getHeight());

        while (isGameFinish != true) {
            if (gameManager.checkMainDiagonal(board.getMyBoard(), board.getWidth(), board.getHeight())
                    || gameManager.checkRows(board.getMyBoard(), board.getWidth(), board.getHeight())
                    || gameManager.checkColumns(board.getMyBoard(), board.getWidth(), board.getHeight())
                    || gameManager.checkOtherDiagonal(board.getMyBoard(), board.getWidth(), board.getHeight())) {
                PlayerSwapper.swapPlayer();
                System.out.println("Победа " + PlayerSwapper.currentPlayer + " !");
                String winnerToStr = "" + PlayerSwapper.currentPlayer;

                GregorianCalendar cannes = new GregorianCalendar();
                DateFormat df = new SimpleDateFormat("Дата: dd MMMM yyy Время: HH:mm");

                String dataToStr = "" + df.format(cannes.getTime());
                gameSaver.saveResult("Победил: " + winnerToStr + " " + dataToStr + "\n");
                break;
            }

            System.out.println("Игрок " + PlayerSwapper.currentPlayer + " cделайте ход, введя координаты через пробел");

            String userData;
            boolean flag = true;
            do {
                userData = scanner.nextLine();
                if (PatternChecker.isCorrectBoardCoordinates(userData)) {

                    if (userData.contains("stop")){
                        System.out.println("Игра окончена");
                        return;
                    }
                    int a = fromStrToCoordinates(userData)[0];
                    int b = fromStrToCoordinates(userData)[1];
                    if (PatternChecker.isCorrectSize(a, b, board.getWidth(), board.getHeight())){
                        if (board.getMyBoard()[a][b] == '-'){
                            break;
                        }
                        }
//                    System.out.println("введите координаты (не более размера поля) через пробел, или stop для выхода");
                }
                System.out.println("введите координаты (не более размера поля, и если не заняты) через пробел, или stop для выхода");
            } while (flag);
            board.getMyBoard()[fromStrToCoordinates(userData)[0]][fromStrToCoordinates(userData)[1]] = PlayerSwapper.currentPlayer;

            gameManager.drawBoard(board.getMyBoard(), board.getWidth(), board.getHeight());
            PlayerSwapper.swapPlayer();


        }
    }

    private int[] fromStrToCoordinates(String userData) {
        String[] numberStr = userData.split(" ");
        int[] coordinates = new int[numberStr.length];
        for (int i = 0; i < numberStr.length; i++) {
            coordinates[i] = Integer.parseInt(numberStr[i]) - 1;
        }
        return coordinates;

    }
}