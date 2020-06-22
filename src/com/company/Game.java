package com.company;

public class Game {
    String[][] board;
    Boolean nextPlayer = false;
    //Player player1;
    //Player player2;

    public Game(int rows, int columns) {
        board = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] temp = new String[columns];
            board[i] = temp;
        }
        play(1);
    }

    public String[][] getBoard(){
        return board;
    }

    /*
    public void addPlayers(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }
    */

    public void play(int howMany){
        printBoard();

        //System.out.println("A következő játékos " + getCurrentPlayer() + ":");
        //mark(getMove(!nextPlayer));
    }

    /*
    private String getMove(Boolean check) {
        return check == true ? Player1.getMove() : Player2.getMove();
    }
    */

    private void mark() {

    }

    private void printBoard() {
        int startNum = 65;
        String[] letters = new String[board[0].length + 1];

        for (int i = 0; i < letters.length; i++) {
            if (i != 0) {
                letters[i] = "" + (char) startNum;
                startNum++;
            }
            else
                letters[i] = " ";
        }

        System.out.println(String.join(" ", letters));

        for (int i = 0; i < board.length; i++) {
            System.out.println(i + 1 + " " + String.join("|", formatBoard(board[i])));
        }
    } //(char)startNum

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

    /*
    private String getCurrentPlayer() {
        return nextPlayer == true ? player1.name : player2.name;
    }
     */
}
