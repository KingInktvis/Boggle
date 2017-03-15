package model;

public class TrieNode extends Node{
    private boolean isLeaf;
    private char character;

    public TrieNode(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public boolean isLeaf() {
        return isLeaf;
    }
}
