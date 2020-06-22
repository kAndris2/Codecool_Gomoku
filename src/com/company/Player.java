package com.company;
import  java.util.Scanner;

public class Player {
    String Name;
    int Points;
    char Type;

    Player(String name, char type){
        Name = name;
        Type = type;
    }

    public int getPoints(){ return Points; }

    public String getMove(){
        return null;
    }
}
