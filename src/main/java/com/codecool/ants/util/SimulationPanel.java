package com.codecool.ants.util;

import com.codecool.ants.Colony;

import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends JPanel implements Runnable {

    public final int screenWidth;
    public final int screenHeight;

    private final int FPS = 60;

    Thread simulationThread;

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    private Colony colony;

    public SimulationPanel(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void setColony(Colony colony) {
        this.colony = colony;
    }

    public void startSimulationThread() {
        simulationThread = new Thread(this);
        simulationThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (simulationThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }

        }

    }

    public void update() {
        colony.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D convertG = (Graphics2D) g;
        colony.draw(convertG);
        convertG.dispose();
    }
}
