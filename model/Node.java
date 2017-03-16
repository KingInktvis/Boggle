package model;

import java.util.ArrayList;
import java.util.Iterator;


public class Node {

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
}
