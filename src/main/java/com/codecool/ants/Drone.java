package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.awt.*;

public class Drone extends Ant{

    private final Queen queen;

    private boolean isMatting = false;

    public Drone(int speed, Position position, Queen queen) {
        super(speed, Direction.STILL, position,AntType.DRONE,32, Color.CYAN);
        this.queen = queen;
    }

    public boolean isMatting() {
        return isMatting;
    }

    public void setMatting(boolean matting) {
        isMatting = matting;
    }

    @Override
    public void movement() {
        moveX();
        moveY();
        queen.matting(this);
        queen.changeMood();
    }

    private void moveX() {
        if (this.position.getX() < queen.position.getX()) {
            this.position.setX(this.position.getX() + Direction.EAST.getX() * speed);
        } else {
            this.position.setX(this.position.getX() + Direction.WEST.getX() * speed);
        }
    }

    private void moveY() {
        if (this.position.getY() < queen.position.getY()) {
            this.position.setY(this.position.getY() + Direction.SOUTH.getY() * speed);
        } else {
            this.position.setY(this.position.getY() + Direction.NORTH.getY() * speed);
        }
    }
}
