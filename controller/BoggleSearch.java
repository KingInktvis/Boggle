package controller;

import model.Board;
import model.Coordinate;
import model.TrieNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BoggleSearch {
    private TrieNode dictionary;
    private Board board;
    private LinkedList<String> found = new LinkedList<String>();

    public BoggleSearch(TrieNode node, Board board) {
        this.dictionary = node;
        this.board = board;
    }

    public void Start() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
//                searchFurther(dictionary, i, j, "");
                search(dictionary, new Coordinate(i, j), "");
            }
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Duration: " + elapsedTime + " ms");
    }

    private void searchFurther(TrieNode searchFrom, int col, int row, String prefix) {

        ArrayList<int[]> neighbours = board.getNeighbours(col, row);//get the field that contain chars that can be added. index 0 is the column and index 1 is the row.
        board.setUsed(col, row);
        for (int i = 0; i < neighbours.size(); i++) {//for every possible neighbour.
            char searchable = board.getChar(neighbours.get(i)[0], neighbours.get(i)[1]);//get the char of this field
            TrieNode n = searchFrom.hasChild(searchable);//look if there is a word that continues with this character. and return this node

            if (n != null) {
                String newWord = prefix + n.getCharacter();
                if (n.isLeaf()) {
                    found.add(newWord);
                    System.out.println(newWord);
                }
                searchFurther(n, neighbours.get(i)[0], neighbours.get(i)[1], newWord);
            }
        }
        board.setUnused(col, row);
    }


    private void search(TrieNode node, Coordinate cord, String prefix) {

        board.addUsedCoordinate(cord);

        ArrayList<Coordinate> options = board.getNeighbourLocations(cord);

        for (Coordinate item : options) {
            char c = board.getChar(item);
            TrieNode next = node.hasChild(c);
            if (next != null) {
                if (next.isLeaf()) addFoundWord(prefix + c);
                search(next, item, prefix + c);
            }
        }

        board.removeLastUsedCoordinate();
    }

    private void addFoundWord(String word) {
        if (!found.contains(word)) {
            found.add(word);
        }
    }

    private void printFounded(){
        for (String word : found) {
            System.out.println(word);
        }
    }

    public LinkedList<String> getFoundedWords(){
        return found;
    }

}