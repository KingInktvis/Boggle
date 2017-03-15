package model;

import java.util.ArrayList;
import java.util.Iterator;


public class Node {

    private ArrayList<TrieNode> children;

    public void addChild(TrieNode node) {
        children.add(node);
    }

    public void addChildIfNeeded(char c) {
        //http://stackoverflow.com/a/85206
        for(Iterator<TrieNode> i = children.iterator(); i.hasNext(); ) {
            TrieNode item = i.next();
            if (item.getCharacter() == c) {
                return;
            }
        }
    }
}
