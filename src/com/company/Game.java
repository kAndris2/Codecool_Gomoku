package com.company;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ArrayList;


public class Game {
    final int START = 65;

    String[][] board;
    ArrayList<Integer> positions = new ArrayList<Integer>();

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
            mark(validateMove(getMove(!nextPlayer)));
            printBoard();
            if (checkWon(howMany)){
                break;
            }

        }
    }

    private String getMove(Boolean check) {
        nextPlayer = check;
        System.out.println("The next player is " + getCurrentPlayer().Name + ":");
        return getCurrentPlayer().getMove();
    }

    private void mark(String[] move) {
        int column = move[0].charAt(0) - START;
        int row = Integer.parseInt(move[1]) - 1;

        for (int i = 0; i < board.length; i++) {
            if (i == row) {
                for (int n = 0; n < board[i].length; n++) {
                    if (n == column) {
                        if (isAvailablePosition(column) && board[i][n] == null) {
                            board[i][n] = String.valueOf(getCurrentPlayer().Type);
                            setAvailablePositions(column);
                        }
                        else {
                            System.out.println("This position is not available!");
                            if (getCurrentPlayer().equals(player1))
                                getMove(true);
                            getMove(false);
                        }
                    }
                }
            }
        }
    }

    private Boolean isAvailablePosition(int pos) {
        if (positions.contains(pos) || positions.size() == 0)
            return true;
        return  false;
    }

    private void setAvailablePositions(int index) {
        index--;
        for (int i = 0; i < 3; i++) {
            if (index >= 0 && !positions.contains(index)) {
                positions.add(index);
            }
            index++;
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

    private void printResult(String character) {
        Player player = getPlayerByCharacter(character.charAt(0));
        System.out.println("The winner is " + player.Name + "!");
    }

    private Boolean checkWon(int howMany) {
        int magas = board.length;
        int szeles = board[0].length;

        for (int y = 0; y < magas; y++) {
            for (int x = 0; x < szeles; x++) {
                int z = 1;
                boolean searching = true;
                //-Horizontal check
                while (searching && (x+z) < szeles && board[y][x] != null) {
                    if (board[y][x].equals(board[y][x+z])) {
                        z++;
                    }
                    else {
                        searching = false;
                    }
                    //
                    if (z == howMany) {
                        printResult(board[y][x]);
                        return true;
                    }
                }
                //-Vertical check
                z = 1;
                searching = true;
                while (searching && (y+z) < magas && board[y][x] != null) {
                    if (board[y][x].equals(board[y+z][x])) {
                        z++;
                    }
                    else {
                        searching = false;
                    }
                    if (z == howMany) {
                        printResult(board[y][x]);
                        return true;
                    }
                }
                //-Diagonal check (right)
                z = 1;
                searching = true;
                while (searching && (x+z) < szeles && (y+z) < magas && board[y][x] != null) {
                    if (board[y][x].equals(board[y+z][x+z])) {
                        z++;
                    }
                    else {
                        searching = false;
                    }
                    if (z == howMany) {
                        printResult(board[y][x]);
                        return true;
                    }
                }
                //-Diagonal check (left)
                z = 1;
                searching = true;
                while (searching && (x-z) >= 0 && (y+z) < magas && board[y][x] != null) {
                    if (board[y][x].equals(board[y+z][x-z])) {
                        z++;
                    }
                    else {
                        searching = false;
                    }
                    if (z == howMany) {
                        printResult(board[y][x]);
                        return true;
                    }
                }
            }
        }
        return false;
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

    private Player getPlayerByCharacter(char character) {
        if (player1.Type == character)
            return player1;
        return player2;
    }
}
