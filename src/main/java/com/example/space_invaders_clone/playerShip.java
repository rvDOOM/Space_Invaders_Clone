package com.example.space_invaders_clone;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class playerShip extends GridEntity implements IGridEntity{
    int lives;
    int points;


    public playerShip(int x, int y, int lives, int points) {
        super(x, y);
        this.lives = lives;
        this.points = points;
    }

    public int getPoints(){
        return points;
    }

    public void setPoints(int i){
        points += i;
    }


    @Override
    public Node getImageView() {

        Rectangle rect = new Rectangle(20, 20);
        rect.setFill(Color.BLUE);
        return rect;
//        Image image = new Image("src/main/images/alien1.png", 100, 100, false, false);
//        ImageView imageView = new ImageView(image);
//        return imageView;
    }


}
