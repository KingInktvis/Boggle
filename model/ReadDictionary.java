package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadDictionary {
    public static TrieNode root;

    public ReadDictionary(){
        TrieNode t = new TrieNode();
        //http://stackoverflow.com/a/4716623
        try(BufferedReader br = new BufferedReader(new FileReader("res/words3.txt"))) {
            String line = br.readLine();

            while (line != null) {
                line = br.readLine();
                t.addWord(line);
            }
        }catch (IOException e){
            System.out.print(e);
        }
        root = t;
    }

    public TrieNode getRoot() {
        return root;
    }
}
