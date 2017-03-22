package model;

import java.util.Iterator;
import java.util.LinkedList;

public class TrieNode{
    private boolean isLeaf;
    private char character;
    private LinkedList<TrieNode> children = new LinkedList<TrieNode>();

    public TrieNode(char character) {
        this.character = character;
    }
    public TrieNode() {}

    public void addChild(TrieNode node) {
        children.addFirst(node);
    }

    public TrieNode addChildIfNeeded(char c) {
        TrieNode existing = hasChild(c);
        if (existing != null) return existing;
        TrieNode n = new TrieNode(c);
        addChild(n);
        return n;
    }

    public TrieNode hasChild(char c) {
        //http://stackoverflow.com/a/85206
        for(Iterator<TrieNode> i = children.iterator(); i.hasNext(); ) {
            TrieNode item = i.next();
            if (item.getCharacter() == c) {
                return item;
            }
        }
        return null;
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
