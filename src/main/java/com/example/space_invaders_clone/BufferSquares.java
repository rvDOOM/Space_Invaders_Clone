package com.example.space_invaders_clone;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BufferSquares extends GridEntity implements IGridEntity{
    public BufferSquares(int x, int y) {
        super(x, y);
    }

    public Node getImageView(){
        Rectangle rect = new Rectangle(20,20);
        rect.setFill(Color.WHITE);
        return rect;
    }
}
