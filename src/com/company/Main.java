package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner io = new Scanner(System.in);
        Game game = new Game(5,5);
        Player p1 = new Player("TestPlayer");
        Menu mainMenu = new Menu();

        //Menu Starts
        int userChoice = -1;
        while (userChoice != 3){
            userChoice = mainMenu.printMainMenu();
            switch (userChoice) {
                case 1:
                    System.out.println(p1.Name);
                case 2:

                case 3:

                default:
                    System.out.println(userChoice);
            }
        }
    }
}
