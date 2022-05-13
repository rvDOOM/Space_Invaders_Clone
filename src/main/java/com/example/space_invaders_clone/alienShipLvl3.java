package com.example.space_invaders_clone;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class alienShipLvl3 extends alienShip {
    public alienShipLvl3(int x, int y) {
        super(x, y, 3, 30);
    }

    @Override
    public Node getImageView() {


        Rectangle rect = new Rectangle(20,20);
        rect.setFill(Color.YELLOW);
        return rect;
//        Image image = new Image("file:alien1.png", 100, 100, false, false);
//        ImageView imageView = new ImageView(image);
//        return imageView;
    }
}
