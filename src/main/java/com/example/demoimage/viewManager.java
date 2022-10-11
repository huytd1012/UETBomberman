package com.example.demoimage;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class viewManager {

  private static final int WIDTH = 1100;
  private static final int HEIGHT = 700;

  //  public static final int WIDTH_ = 20;
//  public static final int HEIGH
  private AnchorPane mainPain;
  private Scene mainScene;
  private Stage mainStage;

  private final static int MENU_BUTTONS_START_X = 150;
  private final static int MENU_BUTTONS_START_Y = 240;

  //  private BomberSubScene credistsSubScene;
  private BomberSubScene helpSubScene;
  private BomberSubScene rulesSubScene;
  private BomberSubScene exitSubScene;
  private BomberSubScene sceneToHide;

  List<BomberButton> menuButtons;

  public viewManager() {
    menuButtons = new ArrayList<>();
    mainPain = new AnchorPane();
    mainScene = new Scene(mainPain, WIDTH, HEIGHT);
    mainStage = new Stage();
    mainStage.setScene(mainScene);
    createSubScenes();
    createSubScenes();
    createButton();
    createLogo();
    createBackground();
  }


  private void showSubScene(BomberSubScene subScene) {
    if (sceneToHide != null) {
      sceneToHide.moveSubScene();
    }
    subScene.moveSubScene();
    sceneToHide = subScene;
  }

  public Stage getMainStage() {
    return mainStage;
  }

  private void createSubScenes() {
    helpSubScene = new BomberSubScene();
    mainPain.getChildren().add(helpSubScene);

    rulesSubScene = new BomberSubScene();
    mainPain.getChildren().add(rulesSubScene);

    exitSubScene = new BomberSubScene();
    mainPain.getChildren().add(exitSubScene);
  }


  private void addMenuButton(BomberButton button) {
    button.setLayoutX(MENU_BUTTONS_START_X);
    button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 120);
    menuButtons.add(button);
    mainPain.getChildren().add(button);
  }

  private void createButton() {
    createStartButton();
    createHelpButton();
    createRulesButton();
    createExitButton();
  }

  private void createStartButton() {
    BomberButton button1 = new BomberButton("Start");
    addMenuButton(button1);

    button1.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        GameViewManager gameManager = new GameViewManager();
        gameManager.createNewGame(mainStage);
      }
    });
  }

  private void createHelpButton() {
    BomberButton button2 = new BomberButton("Help");
    addMenuButton(button2);

    button2.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        showSubScene(helpSubScene);
      }
    });
  }

  private void createRulesButton() {
    BomberButton button3 = new BomberButton("Rules");
    addMenuButton(button3);

    button3.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        showSubScene(rulesSubScene);
      }
    });
  }

  private void createExitButton() {
    BomberButton button4 = new BomberButton("Exit");
    addMenuButton(button4);

    button4.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        mainStage.close();
      }
    });
  }

  // anh nen background.
  private void createBackground() {
    Image backgroundImage = new Image("hello1.png", 1100, 700, false, true);
    BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
        BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
    mainPain.setBackground(new Background(background));
  }

  private void createLogo() {
    ImageView logo = new ImageView("title.png");

    logo.setLayoutX(270);
    logo.setLayoutY(100);

    logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        logo.setEffect(new DropShadow());
      }
    });

    logo.setOnMouseExited(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        logo.setEffect(null);
      }
    });

    mainPain.getChildren().add(logo);
  }
}


