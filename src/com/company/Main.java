package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
	// write your code here
        Keyin keyin = new Keyin();
        Scanner io = new Scanner(System.in);
        Game game = new Game(5,5);
        Player p1 = null;
        Player p2 = null;
        Menu mainMenu = new Menu();

        //Menu Starts
        int userChoice = -1;
        while (userChoice != 4) {
            userChoice = mainMenu.printMainMenu();
            switch (userChoice) {
                case 1: //Initialize players
                    String name = keyin.inString("Enter the name of player1");
                    p1 = new Player(name,'x');
                    String name2 = keyin.inString("Enter the name of player2");
                    p2 = new Player(name2,'o');
                    break;
                case 2: //Start game
                    if (p1 == null || p2 == null){
                        System.out.println("Set players first!");
                        break;
                    }
                    else {
                        game.addPlayers(p1,p2);
                        game.play(3);
                    }
                    break;
                case 3: //Settings
                    int subChoice = -1;
                    subChoice = mainMenu.printSubMenu(new String[]{"Options","Set Size","Set win"});
                    switch ( subChoice){
                        case 1: //Map size
                            boolean isSet = true;
                            while(isSet) {
                                int mapWidth = keyin.inInt("Width of the map:");
                                if (mapWidth < 14) {}
                                int mapHeight = keyin.inInt("Height of the map:");
                            }
                            break;
                        case 2: //Win condidion
                            break;
                        default:
                            System.out.println(subChoice);
                    }
                    break;

                case 4:
                    break;
                default:
                    System.out.println(userChoice);
                    break;
            }
        }

    }
}
