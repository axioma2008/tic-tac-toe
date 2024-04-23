package com.tikTakToe.domain;

import java.io.*;

public class GameSaver {
    public void saveResult(String gameResult){
        try (FileWriter writer = new FileWriter("game_result.txt", true)){
            writer.write(gameResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readGameResult(String filePath) {

        try {
            // Возьмите файл
            File f = new File("game_result.txt");
            //Создайте новый файл
            // Убедитесь, что он не существует
            if (!f.createNewFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    String firstLine = reader.readLine();
                    if (firstLine == null)
                        System.out.println("История игр пуста!");
                    else {
                        System.out.println(firstLine);
                    }
                    while ((line = reader.readLine()) != null) {
                        System.out.println((line));
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("История игр пуста!");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
