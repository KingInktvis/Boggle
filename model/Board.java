package model;

import java.util.Random;

public class Board {

    public static int size = 4;
    public static char[][] board;

    public Board() {
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