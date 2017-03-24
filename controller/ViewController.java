package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
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
    private Board board;

    public ViewController() {
    	board = new Board();
        ReadDictionary dic = new ReadDictionary();
        search = new BoggleSearch(dic.getRoot(), board);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawBord();
    }

    private void drawBord() {
        Font font = new Font("Arial", 40);
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Label label = new Label(String.valueOf(board.getChar(i, j)));
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
