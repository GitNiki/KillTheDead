package start;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by 4 on 20.03.2016.
 */
public class NewGame {

    public static Scene sceneNewGame;

    public void showScene() {
        Group root = new Group();
        sceneNewGame = new Scene(root, 640, 640);
        Main.parentStage.setScene(sceneNewGame);

        sceneNewGame.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ESCAPE){
                    Main.parentStage.setScene(Main.scene);
                }
            }
        });

    }
}
