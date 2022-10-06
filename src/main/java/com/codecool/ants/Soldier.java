package com.codecool.ants;

import com.codecool.ants.geometry.Direction;

import java.awt.*;

public class Soldier extends Ant{


    public Soldier(double speed, int x, int y) {
        super(speed, Direction.NORTH, x, y,AntType.SOLIDER, 48, Color.GREEN);
    }

    @Override
    public void movement() {
        boolean canTurn = canTurn(turnTime);
        double xMoveAmount = this.direction.getX() * this.speed;
        double yMoveAmount = this.direction.getY() * this.speed;
        this.setPosition(xMoveAmount, yMoveAmount);
        if (canTurn) {
            this.direction = (turn(this.direction));
            turnTime = System.nanoTime();
        }
    }

    private Direction turn(Direction direction) {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
        }
        return direction;
    }


    @Override
    protected boolean canTurn(long turnTime) {
        return super.canTurn(turnTime);
    }
}

