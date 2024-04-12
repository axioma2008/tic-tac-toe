package com.tikTakToe.servises;


import com.tikTakToe.visualizer.Menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternChecker {
    public static boolean isCorrectBoardCoordinates(String strForCheck){

        Pattern pattern = Pattern.compile("\\d+\\s\\d+");
        Matcher matcher = pattern.matcher(strForCheck);

        if (matcher.matches())
            return true;
        if (strForCheck.contains("stop"))
            return true;

        return false;

    }

    public static boolean isCorrectSize(int a, int b, int width, int height){

        if (a <= width - 1 && b <= height - 1 && a > -1 && b > -1){
            return  true;
        }
        return false;
    }

    public static boolean isNumber(String str){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches())
            return true;
        return false;
    }

    public static boolean isCorrectNumForMenu(String numForMenu){
        if (!isNumber(numForMenu)){
            return false;
        }
        int result = Integer.parseInt(numForMenu);
        return result <= Menu.getNumberOfOptionsMenu() && result > 0;
    }

    public static boolean isCorrectSettingsPattern(String strForCheck){

        Pattern pattern = Pattern.compile("\\d+\\s\\d+");
        Matcher matcher = pattern.matcher(strForCheck);

        if (matcher.matches())
            return true;

        return false;

    }


}


