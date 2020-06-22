package com.company;

import java.util.Scanner;

public class Menu {

    public int printMainMenu(){
        int swValue;
        Keyin keyin = new Keyin();
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
}
