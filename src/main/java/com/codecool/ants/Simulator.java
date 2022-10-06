package com.codecool.ants;

import com.codecool.ants.util.SimulationPanel;

import javax.swing.*;

public class Simulator {


    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Life of ants");

        SimulationPanel simulationPanel = hDready();
        simulationPanel.setColony( new Colony(10,4,5, simulationPanel));
        window.add(simulationPanel);
        window.pack();
        simulationPanel.startSimulationThread();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private static SimulationPanel hDready() {
        return new SimulationPanel(1280, 720);
    }
    private static SimulationPanel fullHd() {return new SimulationPanel(1920, 1080);}
}
