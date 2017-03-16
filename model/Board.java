package model;

import java.util.Random;

public class Board {

    public static int size = 4;
    public static char[][] board;
    private boolean[][] used;

    public Board(){
        resetUsed();
    }

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

    public int[][] getNeighbours(int col, int row) {
        int[][] ret = new int[8][2];
        int index = 0;
        for (int i = col - 1; i <= col + 1; i++) {
            if (i < 0 || i >= size) continue;
            for (int j = row - 1; j <= row + 1; j++) {
                if (j < 0 || j >= size) continue;
                if (!used[col][row]) {
                    ret[index][0] = i;
                    ret[index][1] = j;
                }
            }
        }
        return ret;
    }

    private void resetUsed() {
        used = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                used[i][j] = false;
            }
        }
    }

    public void setUsed(int col, int row) {
        used[col][row] = true;
    }

    public void setUnused(int col, int row) {
        used[col][row] = true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
            }
        }
    }

    public char getChar(int col, int row){
        return board[col][row];
    }

    public int getSize(){
        return size;
    }
}