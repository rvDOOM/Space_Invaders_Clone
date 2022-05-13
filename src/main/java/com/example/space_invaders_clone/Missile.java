package com.example.space_invaders_clone;

import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Missile extends GridEntity implements IGridEntity, EventHandler {


    boolean isActive;

    public Missile(int x, int y) {
        super(x, y);
        isActive = TRUE;
    }

    @Override
    public Node getImageView() {
        Rectangle rect = new Rectangle(20, 20);
        rect.setFill(Color.ORANGE);
        return rect;
    }

    @Override
    public void handle(Event event) {

    }

}