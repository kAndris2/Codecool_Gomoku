package com.company;
import  java.util.Scanner;

public class Player {
    Keyin keyin = new Keyin();
    String Name;
    int Points;
    char Type;

    Player(String name, char type){
        Name = name;
        Type = type;
    }

    public int getPoints(){ return Points; }

    public String getMove() {
        //Scanner scanner = new Scanner(System.in);
        //return scanner.nextLine();
        String move = keyin.inString();
        return move;
    }
}
