package com.tikTakToe.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class GameSaver {
    public void saveResult(String gameResult){
        try (FileWriter writer = new FileWriter("game_result.txt", true)){
            writer.write(gameResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readGameResult(String filePath){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println((line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }









}
