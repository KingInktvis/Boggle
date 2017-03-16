package model;

import java.util.Random;

public class Board {

    public static int size = 4;
    public static char[][] board;
    private boolean[][] used;

    public void initialize(){
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //http://stackoverflow.com/a/2627801
                Random r = new Random();
                char c = (char) (r.nextInt(26) + 'a');
                board[i][j] = c;
            }
        }
    }

    private void resetUsed() {
        used = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                used[i][j] = false;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
            }
        }
    }

    public char getChar(int i, int j){
        return board[i][j];
    }

    public int getSize(){
        return size;
    }
}