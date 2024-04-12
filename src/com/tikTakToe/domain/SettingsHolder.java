package com.tikTakToe.domain;

import com.tikTakToe.servises.PatternChecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class SettingsHolder {

    public int[] setSettings() {
//        GameManager gameManager = new GameManager();
        System.out.println("Введите ширину и высоту поля через пробел");
        Scanner scanner = new Scanner(System.in);
        String strScanner;


        int a = 0;
        int b = 0;

        do {
            strScanner = scanner.nextLine();
            if (PatternChecker.isCorrectSettingsPattern(strScanner)) {

                a = fromStrToBoardSize(strScanner)[0];
                b = fromStrToBoardSize(strScanner)[1];
                if (a > 2 && a < 15 && b > 2 && b < 15) {
                    break;
                }
            }

            System.out.println("Введите размер доски целым числом через пробел(> 2 и < 15)");
        } while (true);

        saveSettings(strScanner);
        return new int[]{a, b};


    }

    private int[] fromStrToBoardSize(String userData) {
        String[] numberStr = userData.split(" ");
        int[] size = new int[numberStr.length];
        for (int i = 0; i < numberStr.length; i++) {
            size[i] = Integer.parseInt(numberStr[i]);
        }
        return size;

    }


    private void saveSettings(String settings) {
        try (FileWriter writer = new FileWriter("settings.txt", false)) {
            writer.write(settings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] readSavedSettings() {
        int[] boardSettings = new int[1];
        try {
            // Возьмите файл
            File f = new File("settings.txt");
            //Создайте новый файл
            // Убедитесь, что он не существует
            if (!f.createNewFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader("settings.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] numbers = line.split(" ");

                        boardSettings = new int[numbers.length];
                        for (int i = 0; i < numbers.length; i++) {
                            boardSettings[i] = Integer.parseInt(numbers[i]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
//        try (BufferedReader reader = new BufferedReader(new FileReader("settings.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] numbers = line.split(" ");
//                boardSettings = new int[numbers.length];
//                for (int i = 0; i < numbers.length; i++) {
//                    boardSettings[i] = Integer.parseInt(numbers[i]);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return boardSettings;
    }
}

