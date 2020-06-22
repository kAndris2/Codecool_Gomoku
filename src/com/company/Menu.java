package com.company;

import java.util.Scanner;

public class Menu {
    Keyin keyin = new Keyin();
    public int printMainMenu(){
        int swValue;

        // Display menu graphics
        System.out.println("============================");
        System.out.println("|        MAIN MENU         |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Option 1       |");
        System.out.println("|        2. Option 2       |");
        System.out.println("|        3. Exit           |");
        System.out.println("============================");
        swValue = keyin.inInt(" Select option: ");
        return swValue;
    }

    public int printSubMenu(String[] titles){
        int swValue;
        String title = String.format("|        %s         |", titles[0]);
        System.out.println("============================");
        System.out.println(title);
        System.out.println("============================");
        System.out.println("| Options:                 |");
        for (int i = 1 ; i < titles.length ; i++){
            System.out.println(String.format("|        %2d . %s       |",i,titles[i]));
        }
        swValue = keyin.inInt("Select option: ");
        return swValue;
    }
}
