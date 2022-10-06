package com.codecool.ants;

import com.codecool.ants.geometry.Direction;

import java.awt.*;

public class Queen extends Ant{

    private boolean hasMood = false;
    private final long mattingCoolDownTime;
    private final long moodCoolDownTime;

    private boolean hasMatted = false;
    private long lastMatted;
    public Queen(double speed, int x, int y) {
        super(speed, Direction.STILL, x, y,AntType.QUEEN,64, Color.RED);
        mattingCoolDownTime = 1000000000 * 20;
        moodCoolDownTime = 1000000000 * 50;
        lastMatted = System.nanoTime() + 10*1000000000;
    }

    private boolean checkCollisionPont (Drone drone) {
        return false;
    }

    @Override
    public void matting (Drone drone) {
        System.out.println(this.intersects(drone.position.getX(), drone.position.getY(), drone.size, drone.size));
        if (this.intersects(drone.position.getX(), drone.position.getY(), drone.size, drone.size) && hasMood) {
            long mattingTime = System.nanoTime();
            if (System.nanoTime() - mattingCoolDownTime > mattingTime) {
                hasMood = false;
                kick(drone);
                lastMatted = System.nanoTime();
            }
        } else if (this.intersects(drone.position.getX(), drone.position.getY(), drone.size, drone.size) && !hasMood && !drone.isMatting()) {
                kick(drone);

        }
    }

    private void kick (Drone drone) {
       System.out.println("kick");
       direction =this.getRandomDirection();
       drone.position.setX(direction.getX() * (1280/2 * 10));
       drone.position.setY(direction.getY() * (720/2 * 10));
    }
    @Override
    public void changeMood() {
        if (!hasMood && System.nanoTime() - moodCoolDownTime > lastMatted) {
            hasMood = true;
        }
    }


}
