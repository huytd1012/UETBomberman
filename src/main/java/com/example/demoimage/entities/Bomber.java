package com.example.demoimage.entities;

import com.example.demoimage.Background;
import com.example.demoimage.GameViewManager;
import com.example.demoimage.Input;
import com.example.demoimage.graphics.Sprite;
import javafx.event.Event;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;
import java.util.List;
import java.util.Objects;

public class Bomber extends Entity {
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }
    public int speed = 1;

//    GameViewManager g = new GameViewManager();

    public void changeImg(Sprite sprite) {
        this.img = sprite.getFxImage();

    }

    public void handleMovement() {
        if (Input.left) {
            if (i % 30 == 0) {
                changeImg(Sprite.player_left);
            }
            if (i % 30 == 10) {
                changeImg(Sprite.player_left_1);
            }
            if (i % 30 == 20) {
                changeImg(Sprite.player_left_2);
            }
        }
        if (Input.right) {
            if (i % 30 == 0) {
                changeImg(Sprite.player_right);
            }
            if (i % 30 == 10) {
                changeImg(Sprite.player_right_1);
            }
            if (i % 30 == 20) {
                changeImg(Sprite.player_right_2);
            }
        }

    }
    public void move() {
//        collision(GameViewManager.walls);
        if (Input.left && !Objects.equals(collision(GameViewManager.walls), "left")) {
            x = x - speed;
        }
        if (Input.right && !Objects.equals(collision(GameViewManager.walls), "right")) {
            x = x + speed;
        }
        if (Input.up && !Objects.equals(collision(GameViewManager.walls), "up")) {
            y = y - speed;
        }
        if (Input.down && !Objects.equals(collision(GameViewManager.walls), "down")) {
            y += speed;
        }
    }

    public static int i = 0;
    @Override
    public void update() {
//        changeImg();
        handleMovement();
        i++;
        this.move();
    }

    public String collision(List<Entity> entities) {
        for (Entity entity : entities) {
            if (entity instanceof Wall) {
                if (Input.left && this.x == entity.x + img.getWidth() && this.y < entity.y+img.getHeight() && this.y > entity.y-img.getHeight()) {
//                    System.out.println("left");
                    return "left";
                }
                 if (Input.right && this.x + this.img.getWidth() == entity.x && this.y < entity.y+img.getHeight() && this.y > entity.y-img.getHeight()) {
                    System.out.println("right");
//                    System.out.println(entity.x);
                    return "right";
                }
                 if (Input.up && this.y == entity.y + img.getHeight() && this.x < entity.x+img.getWidth() && this.x > entity.x-img.getWidth()) {
//                    System.out.println("up");
                    return "up";
                }  if (Input.down && this.y + img.getHeight() == entity.y && this.x < entity.x+img.getWidth() && this.x > entity.x-img.getWidth()) {
                    System.out.println("down");
                    return "down";
                }
            }
        }
        return "";
    }

}
