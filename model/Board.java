package model;

import java.util.ArrayList;
import java.util.Random;

public class Board {

    public static int size = 10;
    public static char[][] board;
    public boolean[][] used;
    private ArrayList<Coordinate> usedCor = new ArrayList<Coordinate>();

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

    private void resetUsed() {
        used = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                used[i][j] = false;
            }
        }
    }

    public char getChar(int col, int row){
        return board[col][row];
    }

    public char getChar(Coordinate coordinate){
        return board[coordinate.getCol()][coordinate.getRow()];
    }

    public int getSize(){
        return size;
    }

    public ArrayList<Coordinate> getNeighbourLocations(Coordinate cord) {

        ArrayList<Coordinate> neighbours = new ArrayList<Coordinate>();
        int rowLow = cord.getRow() == 0 ? 0 : cord.getRow() - 1;
        int rowHigh = cord.getRow() == size - 1 ? size - 1 : cord.getRow() + 1;
        int colLow = cord.getCol() == 0 ? 0 : cord.getCol() - 1;
        int colHigh = cord.getCol() == size - 1 ? size - 1 : cord.getCol() + 1;

        for (int i = colLow; i <= colHigh; i++) {
            for (int j = rowLow; j <= rowHigh; j++) {
                Coordinate around = new Coordinate(i, j);
                if (!usedCor.contains(around)) {
                    neighbours.add(around);
                }
            }
        }
        return neighbours;
    }

    public void addUsedCoordinate(Coordinate cord){
        usedCor.add(cord);
    }

    public void removeLastUsedCoordinate(){
        usedCor.remove(usedCor.size() - 1);
    }
}