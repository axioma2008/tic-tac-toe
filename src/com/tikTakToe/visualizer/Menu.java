package com.tikTakToe.visualizer;

public class Menu {

    private static final int numberOfOptions = 4;

    public static void printMenu(){
        System.out.println("1. Новая игра");
        System.out.println("2. История игр");
        System.out.println("3. Настройки");
        System.out.println("4. Выйти");

    }

    public static int getNumberOfOptionsMenu(){
        return numberOfOptions;
    }
}
