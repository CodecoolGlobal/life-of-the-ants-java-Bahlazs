package com.codecool.ants;

import com.codecool.ants.util.SimulationPanel;
import org.jetbrains.annotations.NotNull;

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
    private SimulationPanel sp;

    public Colony(int workers, int drones, int soldiers, SimulationPanel sp) {
        workerNum = workers;
        droneNum = drones;
        soldierNum = soldiers;
        this.sp = sp;
        populate();

    }

    private void populate() {
        createAnts(queenNum, AntType.QUEEN);
        createAnts(workerNum, AntType.WORKER);
        createAnts(droneNum, AntType.DRONE);
        createAnts(soldierNum, AntType.SOLIDER);

    }

    private void createAnts(int antNum ,AntType antType) {
        for ( int i = 0; i < antNum; i++) {
            switch (antType) {
                case QUEEN:
                    ants.add(new Queen(0, sp.getScreenWidth()/2-32, sp.getScreenHeight()/2-32));
                    System.out.println();
                    break;
                case DRONE:
                    int[] dronePosition = getRandomAntPos();
                    ants.add(new Drone(6, dronePosition[0], dronePosition[1], ants.get(0)));
                    break;
                case WORKER:
                    int[] workerPosition = getRandomAntPos();
                    ants.add(new Worker(3, workerPosition[0], workerPosition[1]));
                    break;
                case SOLIDER:
                    int[] soliderPosition = getRandomAntPos();
                    ants.add(new Soldier(5, soliderPosition[0], soliderPosition[1]));
                    break;
            }
        }
    }
    private int [] getRandomAntPos() {
        int x = randomize(1240);
        int y = randomize(680-64);
        return new int[]{x,y};
    }

    private int randomize(int screenNum) {
        Random random = new Random();
        return random.nextInt(screenNum) + 20;
    }

    public void update() {
        for (Ant ant: ants) {
            ant.movement();
        }
    }

    public void draw(Graphics2D g) {
        for (Ant ant: ants) {
            placeObjectOnScreen(g, ant.color, ant.position.getX(),ant.position.getY(),ant.size);
        }
    }

    private void placeObjectOnScreen(Graphics2D g, Color color, double x, double y, int size) {
        g.setColor(color);
         int intX = (int)x;
         int intY = (int)y;
        g.fillRect(intX,intY,size,size);

    }
}
