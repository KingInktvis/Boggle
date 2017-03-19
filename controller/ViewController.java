package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Board;
import model.ReadDictionary;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable{

    @FXML
    private GridPane bordView;
    @FXML
    private TextArea found;
    private BoggleSearch search;
    @FXML
    private Label amount;

    public ViewController() {
        ReadDictionary dic = new ReadDictionary();
        search = new BoggleSearch(dic.getRoot(), new Board());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawBord();
    }

    private void drawBord() {
        Board b = new Board();
        Font font = new Font("Arial", 40);
        for (int i = 0; i < b.getSize(); i++) {
            for (int j = 0; j < b.getSize(); j++) {
                Label label = new Label(String.valueOf(b.getChar(i, j)));
                label.setFont(font);
                bordView.add(label, i, j);
            }
        }
        bordView.setHgap(20);
        bordView.setVgap(15);
    }

    @FXML
    private void start() {
        search.Start();
        drawFoundWords();
    }

    private void drawFoundWords() {
        String list = "";
        for (String word : search.getFoundedWords()) {
            list = list + word + "\n";
        }
        found.setText(list);
        amount.setText(Integer.toString(search.getFoundedWords().size()));
    }
}
