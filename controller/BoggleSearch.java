package controller;


import model.Board;
import model.Node;
import model.RootNode;

public class BoggleSearch {
    private RootNode dictionary;
    private Board board;

    public BoggleSearch(RootNode node, Board board) {
        this.dictionary = node;
        this.board = board;
    }

    public void Start() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {

            }
        }
    }

    public void searchFurther(Node searchFrom) {

    }
}
