package com.example.space_invaders_clone;

import javafx.scene.Node;

public abstract class GridEntity{
    private int x;
    private int y;

    public GridEntity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Node getImageView() {
        return null;
    }
}
