package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Board;
import model.ReadDictionary;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable{

    @FXML
    private GridPane bordView;
    private BoggleSearch search;

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
        for (int i = 0; i < b.getSize(); i++) {
            for (int j = 0; j < b.getSize(); j++) {
                bordView.add(new Label(String.valueOf(b.getChar(i, j))), i, j);
            }
        }
        bordView.setHgap(10);
        bordView.setVgap(10);
    }

    @FXML
    private void start() {
        search.Start();
    }
}
