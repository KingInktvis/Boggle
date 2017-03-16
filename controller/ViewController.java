package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Board;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable{

    @FXML
    private GridPane bord;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawBord();
    }

    public void drawBord() {
        Board b = new Board();
        for (int i = 0; i < b.getSize(); i++) {
            for (int j = 0; j < b.getSize(); j++) {
                bord.add(new Label(new StringBuilder().append(b.getChar(i,j)).toString()), i, j);
            }
        }
        bord.setHgap(10);
        bord.setVgap(10);
    }
}
