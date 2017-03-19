package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
    private ScrollPane found;
    private BoggleSearch search;

    public ViewController() {
        ReadDictionary dic = new ReadDictionary();
        search = new BoggleSearch(dic.getRoot(), new Board(), found);
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
    }
}
