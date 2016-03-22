package start;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by 4 on 20.03.2016.
 */
public class NewGame {

    public static Scene sceneNewGame;

    /*Картинки инициализируются тут*/
    private Image backgroundImage = new Image("/images/background.jpg");

    /*Определяем ImageView на основе Image*/
    private ImageView backgroundImageView = new ImageView(backgroundImage);

    public void showScene() {

        Group root = new Group();
        /*Добавление в группу(на сцену)*/
        root.getChildren().add(0, backgroundImageView);

        /*Определение сцены в которой находится группа*/
        sceneNewGame = new Scene(root, 640, 640);
        /*Размещаем сцену в нашем окне, вместо той, которая была раньше*/
        Main.parentStage.setScene(sceneNewGame);

        /*Обработчик на нажатие клавишь клавиатуры*/
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
