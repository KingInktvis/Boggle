package model;

public class TrieNode extends Node{
    private boolean isLeaf;
    private char character;

    public TrieNode(char character) {
        this.character = character;
    }
    public TrieNode() {

    }

    public char getCharacter() {
        return character;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void addWord(String word) {
        if (word == null) return;
        TrieNode node = addChildIfNeeded(word.charAt(0));
        if (word.length() > 1) {
            node.addWord(word.substring(1));
        }else {
            node.setLeaf();
        }
    }

    public void setLeaf(){isLeaf = true;}
}
