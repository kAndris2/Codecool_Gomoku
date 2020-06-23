package com.company;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Game {
    final int START = 65;

    String[][] board;
    Boolean nextPlayer = false;
    Player player1;
    Player player2;

    public Game(int rows, int columns) {
        board = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] temp = new String[columns];
            board[i] = temp;
        }
    }

    public String[][] getBoard(){
        return board;
    }

    public void addPlayers(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }

    public void play(int howMany){
        printBoard();

        while (true) {
            System.out.println("The next player is " + getCurrentPlayer().Name + ":");
            mark(validateMove(getMove(!nextPlayer)));
            printBoard();
        }
    }

    private String getMove(Boolean check) {
        nextPlayer = check;
        return getCurrentPlayer().getMove();
    }

    private void mark(String[] move) {
        int column = move[0].charAt(0) - START;
        int row = Integer.parseInt(move[1]) - 1;

        for (int i = 0; i < board.length; i++) {
            if (i == row) {
                for (int n = 0; n < board[i].length; n++) {
                    if (n == column) {
                        board[i][n] = String.valueOf(getCurrentPlayer().Type);
                    }
                }
            }
        }
    }

    private void printBoard() {
        int startLetter = START;
        String[] letters = new String[board[0].length + 1];

        for (int i = 0; i < letters.length; i++) {
            if (i != 0) {
                letters[i] = "" + (char) startLetter;
                startLetter++;
            }
            else
                letters[i] = " ";
        }

        System.out.println(String.join(" ", letters));

        for (int i = 0; i < board.length; i++) {
            System.out.println(i + 1 + " " + String.join("|", formatBoard(board[i])));
        }
    }

    private void printResult() {

    }

    private Boolean isFull() {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int n = 0; n < board[i].length; n++) {
                if (board[i][n] == null) {
                    count++;
                }
            }
        }
        return count == 0;
    }

    private String[] formatBoard(String[] table) {
        String[] result = new String[table.length];

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                result[i] = "_";
            else
                result[i] = table[i];
        }
        return result;
    }

    private String[] validateMove(String move) {
        String[] result = new String[2];
        char c = move.charAt(0);

        result[0] = String.valueOf(c);

        String temp = "";
        for (int i = 0; i < move.length(); i++) {
            if (i != 0) {
                temp += move.charAt(i);
            }
        }
        result[1] = temp;

        return result;
    }

    private Player getCurrentPlayer() {
        return nextPlayer == true ? player1 : player2;
    }
}
