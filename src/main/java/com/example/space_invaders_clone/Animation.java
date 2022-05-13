package com.example.space_invaders_clone;


public class Animation extends javafx.animation.AnimationTimer {


    private long prevTime;

    public Animation(){
        prevTime = 0;
    }

    @Override
    public void handle(long l) {
        long diff = l - prevTime;
        if(diff > 5e9) {
            prevTime = l;
        }
    }
}
