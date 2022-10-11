package com.example.demoimage;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class BomberSubScene extends SubScene {

  private final static String FONT_PATH = "kenvector_future.ttf";
  private final static String BACKGROUND_IMAGE = "panel_brown.png";

  private boolean isHidden;


  public BomberSubScene() {
    super(new AnchorPane(), 600, 400);
    prefHeight(400);
    prefWidth(600);

    BackgroundImage image = new BackgroundImage(
        new Image(BACKGROUND_IMAGE, 600, 400, false, true), BackgroundRepeat.REPEAT,
        BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

    AnchorPane root2 = (AnchorPane) this.getRoot();

    root2.setBackground(new Background(image));

    isHidden = true;

    setLayoutX(1100);
    setLayoutY(180);

  }

  public void moveSubScene() {
    TranslateTransition transition = new TranslateTransition();
    transition.setDuration(Duration.seconds(0.3));
    transition.setNode(this);

    if(isHidden) {
      transition.setToX(-680);
      isHidden = false;
    }
    else {
      transition.setToX(0);
      isHidden = true;
    }


    transition.play();
  }

  public AnchorPane getPane() {
    return (AnchorPane) this.getRoot();
  }

}
