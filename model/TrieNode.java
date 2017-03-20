package model;

import java.util.ArrayList;
import java.util.Iterator;

public class TrieNode{
    private boolean isLeaf;
    private char character;
    private ArrayList<TrieNode> children = new ArrayList<TrieNode>();

    public void addChild(TrieNode node) {
        children.add(node);
    }

    public TrieNode addChildIfNeeded(char c) {
        //http://stackoverflow.com/a/85206

        TrieNode existing = hasChild(c);
        if (existing != null) return existing;
        TrieNode n = new TrieNode(c);
        addChild(n);
        return n;
    }

    public TrieNode hasChild(char c) {
        for(Iterator<TrieNode> i = children.iterator(); i.hasNext(); ) {
            TrieNode item = i.next();
            if (item.getCharacter() == c) {
                return item;
            }
        }
        return null;
    }

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
