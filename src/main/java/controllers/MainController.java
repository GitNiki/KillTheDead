package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by 4 on 11.03.2016.
 */
public class MainController {
    @FXML
    Label label;
    public void touchBtn(ActionEvent actionEvent) {
        label.setText("KillTheDead");

    }
}
