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
                search(dictionary, new Coordinate(i, j), "");
            }
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Duration: " + elapsedTime + " ms");
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

    public LinkedList<String> getFoundedWords(){
        return found;
    }

}