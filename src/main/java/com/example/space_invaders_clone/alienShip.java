package com.example.space_invaders_clone;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class alienShip extends GridEntity implements IGridEntity{

    private int hitPoints;
    private int pointValue;
//    private int speed;
    private boolean isAlive;

    public alienShip(int x, int y, int hitPoints, int pointValue) {
        super(x, y);
        this.hitPoints = hitPoints;
        this.pointValue = pointValue;
        isAlive = true;
    }




    @Override
    public Node getImageView() {


        Rectangle rect = new Rectangle(20,20);
        rect.setFill(Color.BROWN);
        return rect;
//        Image image = new Image("file:alien1.png", 100, 100, false, false);
//        ImageView imageView = new ImageView(image);
//        return imageView;
    }

    public int getPointValue() {
        return pointValue;
    }
}
