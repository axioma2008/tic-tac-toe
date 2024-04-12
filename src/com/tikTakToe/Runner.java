package com.tikTakToe;


import com.tikTakToe.domain.GameSaver;
import com.tikTakToe.domain.GameStarter;
import com.tikTakToe.domain.PlayerSwapper;
import com.tikTakToe.domain.SettingsHolder;
import com.tikTakToe.servises.GameManager;
import com.tikTakToe.servises.PatternChecker;
import com.tikTakToe.visualizer.Menu;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        GameSaver gameSaver = new GameSaver();

        Scanner scanner = new Scanner(System.in);

        gameManager.readSavedSettings();

        String menuContainer = "";
        while (!menuContainer.equals("4")) {
            Menu.printMenu();

            do {
                menuContainer = scanner.nextLine();
                if (!PatternChecker.isCorrectNumForMenu(menuContainer))
                    System.out.println("введите число от одного до четырех");
            } while (!PatternChecker.isCorrectNumForMenu(menuContainer));
            if (menuContainer.equals("4")) {
                return;
            }
            if (menuContainer.equals("1")) {
                gameManager.gameStart();
            }

            if (menuContainer.equals("2")) {
                gameSaver.readGameResult("game_result.txt");
            }

            if (menuContainer.equals("3")) {
                gameManager.setSettings();

            }
        }
    }
}


