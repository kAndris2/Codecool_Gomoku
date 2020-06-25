package com.company;
import  java.util.Scanner;

public class Player {
    Keyin keyin = new Keyin();
    String Name;
    int Points;
    int Stones;
    char Type;

    Player(String name, char type){
        Name = name;
        Type = type;
        Stones = 100;
    }

    public int getPoints(){ return Points; }

    public String getMove() {
        //Scanner scanner = new Scanner(System.in);
        //return scanner.nextLine();
        String move = keyin.inString().toUpperCase();
        return move;
    }
}
