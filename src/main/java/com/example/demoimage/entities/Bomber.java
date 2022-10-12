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
    static String last = "";
    public void handleMovement() {
        if (Input.left) {
            if (this.x % 32 == 0) {
                changeImg(Sprite.player_left);
                last = "left";
            }else if (this.x % 32 == 10) {
                changeImg(Sprite.player_left_1);
                last = "left_1";
            }else if (this.x % 32 == 20) {
                changeImg(Sprite.player_left_2);
                last = "left_2";
            }
        }
        if (!Input.left && (last.equals("left_1") || last.equals("left_2"))) {
            changeImg(Sprite.player_left);
            last = "left";
        }
        if (Input.right) {
            if (this.x % 32 == 0) {
                changeImg(Sprite.player_right);
                last = "right";
            }else if (this.x % 32 == 10) {
                changeImg(Sprite.player_right_1);
                last = "right_1";
            }else if (this.x % 32 == 20) {
                changeImg(Sprite.player_right_2);
                last = "right_2";
            }
        }
        if (!Input.right && (last.equals("right_1") || last.equals("right_2"))) {
            changeImg(Sprite.player_right);
            last = "right";
        }
        if (!Input.left && !Input.right && Input.up) {
            if (this.y % 32 == 0) {
                changeImg(Sprite.player_up);
                last = "up";
            }else if (this.y % 32 == 10) {
                changeImg(Sprite.player_up_1);
                last = "up_1";
            }else if (this.y % 32 == 20) {
                changeImg(Sprite.player_up_2);
                last = "up_2";
            }
        }
        if (!Input.up && (last.equals("up_1") || last.equals("up_2"))) {
            changeImg(Sprite.player_up);
            last = "up";
        }
        if (!Input.left && !Input.right && Input.down) {
            if (this.y % 32 == 0) {
                changeImg(Sprite.player_down);
                last = "down";
            }else if (this.y % 32 == 10) {
                changeImg(Sprite.player_down_1);
                last = "down_1";
            }else if (this.y % 32 == 20) {
                changeImg(Sprite.player_down_2);
                last = "down_2";
            }
        }
        if (!Input.down && (last.equals("down_1") || last.equals("down_2"))) {
            changeImg(Sprite.player_down);
            last = "down";
        }

    }
    public void move() {
//        collision(GameViewManager.walls);
        if (Input.left && !collision(GameViewManager.walls)) {
            x = x - speed;
        }
        if (Input.right && !collision(GameViewManager.walls)) {
            x = x + speed;
        }
        if (Input.up && !collision(GameViewManager.walls)) {
            y = y - speed;
        }
        if (Input.down && !collision(GameViewManager.walls)) {
            y += speed;
        }
    }


    @Override
    public void update() {
        handleMovement();
        this.move();
    }

    public boolean collision(List<Entity> entities) {
        for (Entity entity : entities) {
            if (entity instanceof Wall) {
                if (Input.left && this.x == entity.x + img.getWidth() && this.y < entity.y+img.getHeight() && this.y > entity.y-img.getHeight()) {
//                    System.out.println("left");
                    return true;
                }
                 if (Input.right && this.x + this.img.getWidth() - 10 == entity.x && this.y < entity.y+img.getHeight() && this.y > entity.y-img.getHeight()) {
//                    System.out.println("right");
                    return true;
                }
                 if (Input.up && this.y == entity.y + img.getHeight() && this.x < entity.x+img.getWidth() && this.x + this.img.getWidth()-10 > entity.x) {
//                    System.out.println("up");
                    return true;
                }  if (Input.down && this.y + img.getHeight() == entity.y && this.x < entity.x+img.getWidth() && this.x -10> entity.x-img.getWidth()) {
//                    System.out.println("down");
                    return true;
                }
            }
        }
        return false;
    }

}
