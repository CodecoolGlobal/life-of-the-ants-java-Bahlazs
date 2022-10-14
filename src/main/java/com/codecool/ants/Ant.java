package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.awt.*;
import java.util.Random;

public abstract class Ant extends Rectangle{

    protected AntType antType;
    protected final double speed;
    protected Position position;
    protected Direction direction;

    protected int size;

    protected Color color;

    protected long startTime;

    protected long turnTime;


    public Ant(double speed, Direction direction, Position position, AntType antType, int size, Color color) {
        super((int)position.getX(),(int)position.getY(),size,size);
        this.position = position;
        this.speed = speed;
        this.direction = direction;
        startTime = System.nanoTime();
        turnTime = startTime;
        this.antType = antType;
        this.size = size;
        this.color = color;
    }

    public void setPosition(double x, double y){
        if (position.getX() + x >= 0 && position.getY() + y >= 0 && position.getX() + x <= 1280-64 && position.getY() + y <= 720-64) {
            position.setX(position.getX() + x);
            position.setY(position.getY() + y);
        }
    }

    public void movement() {};

    protected boolean canTurn(long turnTime) {
        boolean canTurn = false;
        long currentTime = System.nanoTime();
        long coolDownTime = 2000000000; // nanosecond
        if (turnTime < (currentTime - coolDownTime)) {
            canTurn = true;
        }
        return canTurn;
    }


    protected Direction getRandomDirection() {
        Direction[] directions = {Direction.NORTH,Direction.WEST,Direction.SOUTH,Direction.EAST};
        Random random = new Random();
        int i = random.nextInt(4);
        return directions[i];
    }
}
