import model.Board;
import model.ReadDictionary;
import view.Gui;

public class Start {
    public static void main(String args[]) {
        new Board().initialize();
        new ReadDictionary();
        new Gui().go(args);
    }
}