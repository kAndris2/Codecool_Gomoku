package com.company;

public class Game {
    String[][] board;

    public Game(int length, int width) {
        board = new String[length][width];

        for (int i = 0; i < width; i++) {
            String[] temp = new String[length];
            board[i] = temp;
        }
    }
}
