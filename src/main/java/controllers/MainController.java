package controllers;

import javafx.event.ActionEvent;
import start.NewGame;

/**
 * Created by 4 on 11.03.2016.
 */
public class MainController {

    public void newFame(ActionEvent actionEvent) {
        NewGame a = new NewGame();
        a.showScene();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
