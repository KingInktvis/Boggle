package controller;


import model.Board;
import model.Node;
import model.RootNode;
import model.TrieNode;

import java.util.ArrayList;
import java.util.HashMap;
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
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                searchFurther(dictionary, i, j, "");
            }
        }
    }

    private void searchFurther(Node searchFrom, int col, int row, String prefix) {
        int[][] neighbours = board.getNeighbours(col, row);

        for (int i = 0; i < neighbours.length; i++) {
            char searchable = board.getChar(neighbours[i][0], neighbours[i][1]);
            TrieNode n = searchFrom.hasChild(searchable);


            if (n != null) {
                if (n.isLeaf()) found.add(prefix + searchable);
                searchFurther(n, neighbours[i][0], neighbours[i][1], prefix + searchable);
            }
        }
    }
}
