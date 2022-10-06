package com.codecool.ants;

import com.codecool.ants.geometry.Direction;

import java.awt.*;
import java.util.Random;

public class Worker extends Ant{


    public Worker(double speed, int x, int y) {
        super(speed, Direction.WEST, x, y,AntType.WORKER, 16, Color.WHITE);
    }

    @Override
    public void movement() {
      double xMoveAmount = direction.getX() * this.speed;
      double yMoveAmount = direction.getY() * this.speed;
      this.setPosition(xMoveAmount, yMoveAmount);
      if (canTurn(turnTime)) {
          turnTime = System.nanoTime();
          direction = this.getRandomDirection();
      }
    }


}
