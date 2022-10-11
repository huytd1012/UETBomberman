package com.example.demoimage;


import com.example.demoimage.entities.Bomber;
import com.example.demoimage.entities.Entity;
import com.example.demoimage.entities.Grass;
import com.example.demoimage.entities.Wall;
import com.example.demoimage.graphics.Sprite;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class HelloApplication extends Application {

  public static final int WIDTH = 1100;
  public static final int HEIGHT = 700;

  private GraphicsContext gc;
  private Canvas canvas;
  private List<Entity> entities = new ArrayList<>();
  private List<Entity> stillObjects = new ArrayList<>();

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) throws IOException {
    viewManager manage = new viewManager();
    stage = manage.getMainStage();
    stage.show();
  }
}