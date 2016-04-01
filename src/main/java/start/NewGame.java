package start;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * Created by 4 on 20.03.2016.
 */
public class NewGame {

    public static Scene sceneNewGame;
    private static Group root;

    /*Картинки инициализируются тут*/
    private Image backgroundImage = new Image("/images/background.jpg");
    private Image persImage = new Image("/images/zombiemove/zombie3.png");
    private Image zombieImage1 = new Image("/images/zombiemove/zombie1.png");
    private Image zombieImage2 = new Image("/images/zombiemove/zombie2.png");
    private Image zombieImage3 = new Image("/images/zombiemove/zombie3.png");

    /*Определяем ImageView на основе Image*/
    private ImageView backgroundImageView = new ImageView(backgroundImage);
    private ImageView persImageView = new ImageView(persImage);
    private ImageView zombieImageView1 = new ImageView(zombieImage1);
    private ImageView zombieImageView2 = new ImageView(zombieImage2);
    private ImageView zombieImageView3 = new ImageView(zombieImage3);

    private Timeline zombieMoveTimeLine, timelineLeftMove, timelineRightMove;

    public void showScene() {
        root = new Group();
        /*Добавление в группу(на сцену)*/
        root.getChildren().add(0, backgroundImageView);

        /*инициализация игрока*/
        initPlayer();

        /*инициализация зомби*/
        initZombie();

        /*Определение сцены в которой находится группа*/
        sceneNewGame = new Scene(root, 640, 640);
        /*Размещаем сцену в нашем окне, вместо той, которая была раньше*/
        Main.parentStage.setScene(sceneNewGame);

        /*обработчик на отпускание клавишь клавиатуры*/
        sceneNewGame.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.RIGHT){
                    timelineRightMove.stop();
                }
                if(event.getCode() == KeyCode.LEFT){
                    timelineLeftMove.stop();
                }
            }
        });

        /*Обработчик на нажатие клавишь клавиатуры*/
        sceneNewGame.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ESCAPE){
                    Main.parentStage.setScene(Main.scene);
                }

                if(event.getCode() == KeyCode.RIGHT){
                    timelineRightMove.play();
                }
                if(event.getCode() == KeyCode.LEFT){
                    timelineLeftMove.play();
                }
            }
        });

        timelineLeftMove = new Timeline(new KeyFrame(
                Duration.millis(2),
                ae -> {
                    if(root.getChildren().get(1).getLayoutX() > 0){
                        root.getChildren().get(1).setLayoutX(root.getChildren().get(1).getLayoutX() - 1);
                    }
                }));
        timelineLeftMove.setCycleCount(Animation.INDEFINITE);

        timelineRightMove = new Timeline(new KeyFrame(
                Duration.millis(2),
                ae -> {
                    if(root.getChildren().get(1).getLayoutX() < 550)
                    root.getChildren().get(1).setLayoutX(root.getChildren().get(1).getLayoutX() + 1);
                }));
        timelineRightMove.setCycleCount(Animation.INDEFINITE);
    }

    public void initPlayer(){
        root.getChildren().add(1, persImageView);
        root.getChildren().get(1).setLayoutX(320);
        root.getChildren().get(1).setLayoutY(550);
    }


    /*думать - исправлять*/
    public void initZombie(){
        root.getChildren().add(2, zombieImageView1);
        root.getChildren().get(2).setLayoutX(50);
        root.getChildren().get(2).setLayoutY(50);

        zombieMoveTimeLine = new Timeline(new KeyFrame(
                Duration.millis(25),
                ae -> move()));
        zombieMoveTimeLine.setCycleCount(Animation.INDEFINITE);
        zombieMoveTimeLine.play();
    }

    private void move() {
        root.getChildren().get(2).setLayoutY(root.getChildren().get(2).getLayoutY() + 1);
    }
}
