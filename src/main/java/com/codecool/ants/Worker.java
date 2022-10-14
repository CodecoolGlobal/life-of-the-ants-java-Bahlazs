package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.awt.*;
import java.util.Random;

public class Worker extends Ant{


    public Worker(double speed, Position position) {
        super(speed, Direction.WEST, position ,AntType.WORKER, 16, Color.WHITE);
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
