package com.codecool.ants;

import com.codecool.ants.geometry.Position;
import com.codecool.ants.util.SimulationPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {

    private final List<Ant> ants = new ArrayList<>();
    private final static int queenNum = 1;
    private final int workerNum;
    private final int droneNum;
    private final int soldierNum;

    private Queen queen;

    private int queenXPos;

    private  int queenYPos;
     private Position queenPos;
    private SimulationPanel sp;

    public Colony(int workers, int drones, int soldiers, SimulationPanel sp) {
        workerNum = workers;
        droneNum = drones;
        soldierNum = soldiers;
        this.sp = sp;
        queenXPos = sp.getScreenWidth() / 2 - 32;
        queenYPos = sp.getScreenHeight() / 2 - 32;
        queenPos = new Position(queenXPos, queenYPos);
        populate();

    }

    private void populate() {
        createQueen();
        createDrones();
        createSoldiers();
        createWorkers();

    }


    private void createQueen() {
        queen = new Queen(0, queenPos);
        ants.add(queen);
    }

    private void createDrones() {
        for (int i = 0; i < droneNum; i++) {
            ants.add(new Drone(6, getRandomAntPos(), queen));
        }
    }

    private void createSoldiers() {
        for (int i = 0; i < soldierNum; i++) {
            ants.add(new Soldier(5, getRandomAntPos()));
        }
    }

    private void createWorkers() {
        for (int i = 0; i < workerNum; i++) {
            ants.add(new Worker(3, getRandomAntPos()));
        }

    }


    private Position getRandomAntPos() {
        int x = randomize(1240);
        int y = randomize(680 - 64);
        return new Position(x, y);
    }

    private int randomize(int screenNum) {
        Random random = new Random();
        return random.nextInt(screenNum) + 20;
    }

    public void update() {
        for (Ant ant : ants) {
            ant.movement();
        }
    }

    public void draw(Graphics2D g) {
        for (Ant ant : ants) {
            placeObjectOnScreen(g, ant.color, ant.position.getX(), ant.position.getY(), ant.size);
        }
    }

    private void placeObjectOnScreen(Graphics2D g, Color color, double x, double y, int size) {
        g.setColor(color);
        int intX = (int) x;
        int intY = (int) y;
        g.fillRect(intX, intY, size, size);

    }
}
