import model.Board;
import model.ReadDictionary;
import view.Gui;

public class Start {
    public static void main(String args[]) {
        new Gui().go(args);
        new Board();
        new ReadDictionary();
    }
}