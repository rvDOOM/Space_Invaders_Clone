package com.example.space_invaders_clone;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

public class KeyListener implements EventHandler {

    playerShip player;
    int x;
    int y;
    GridPane map;

    public KeyListener(playerShip player, GridPane map){
        this.player = player;
        x = player.getX();
        y = player.getY();
        this.map = map;
    }


    @Override
    public void handle(Event event) {

    }
}
