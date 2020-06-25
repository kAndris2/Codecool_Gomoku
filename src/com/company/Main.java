package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
	// write your code here
        Keyin keyin = new Keyin();
        Scanner io = new Scanner(System.in);

        int mapWidth = 14;
        int mapHeight = 14;

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
                        Game game = new Game(mapHeight,mapWidth);
                        game.addPlayers(p1,p2);
                        game.play(5);
                    }
                    break;
                case 3: //Settings
                    int subChoice = -1;
                    subChoice = mainMenu.printSubMenu(new String[]{"Options","Set Size","Back"});
                    switch ( subChoice){
                        case 1: //Map size
                            boolean isSet = true;
                            while(isSet) {
                                mapWidth = keyin.inInt("Width of the map:");
                                mapHeight = keyin.inInt("Height of the map:");
                                if (mapWidth < 14 || mapHeight < 14) {System.out.println("The minimum is 14!");}
                                else {isSet = false;}
                            }
                            break;
                        case 2: //Back
                            break;
                        default:
                            System.out.println(subChoice);
                            break;
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
