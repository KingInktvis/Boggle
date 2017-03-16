package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadDictionary {
    public static TrieNode root;

    public ReadDictionary(){
        int i = 0;
        TrieNode t = new TrieNode();
        //http://stackoverflow.com/a/4716623
        try(BufferedReader br = new BufferedReader(new FileReader("res/dict.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                t.addWord(line);
                i++;
            }
            String everything = sb.toString();
        }catch (IOException e){
            System.out.print(e);
        }
        root = t;
    }

    public TrieNode getRoot() {
        return root;
    }
}
