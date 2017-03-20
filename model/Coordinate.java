package model;

public class Coordinate {
    private int row;
    private int col;

    public Coordinate(int col, int row){
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object object){
        boolean isSame = false;

        if (object != null && object instanceof Coordinate) {
            Coordinate o = (Coordinate) object;
            if (col == o.getCol() && row == o.getRow()) {
                isSame = true;
            }
        }
        return isSame;
    }
}