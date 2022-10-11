package com.example.demoimage;

import com.example.demoimage.entities.Bomber;
import com.example.demoimage.graphics.Sprite;

public class Background implements Runnable{
    Bomber bomber;

    public Background(Bomber bomber) {
        this.bomber = bomber;
    }

    @Override
    public void run() {
        try {
            if (Input.left) {
                bomber.changeImg(Sprite.player_left_1);
                Thread.sleep(500);
                bomber.changeImg(Sprite.player_left_2);
                Thread.sleep(500);
                bomber.changeImg(Sprite.player_left);
                Thread.sleep(500);
            }
//            if (Input.right) {
//                this.img = Sprite.player_right.getFxImage();
//            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
