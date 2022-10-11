package com.example.demoimage;
import com.example.demoimage.entities.Bomber;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Input {
    public static boolean left, right, up, down;

    public static void createKeyListener(Scene gameScene) {
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    left = true;
                } else if (event.getCode() == KeyCode.RIGHT) {
                    right = true;
                } else if (event.getCode() == KeyCode.UP) {
                    up = true;
                } else if (event.getCode() == KeyCode.DOWN) {
                    down = true;
                }
            }
        });

        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    left = false;
                } else if (event.getCode() == KeyCode.RIGHT) {
                    right = false;
                } else if (event.getCode() == KeyCode.UP) {
                    up = false;
                } else if (event.getCode() == KeyCode.DOWN) {
                    down = false;
                }
            }
        });
    }

}
