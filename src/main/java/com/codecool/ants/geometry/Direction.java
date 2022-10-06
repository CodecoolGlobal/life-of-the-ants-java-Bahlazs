package com.codecool.ants.geometry;

    public enum Direction {
        NORTH(0, -0.1),
        EAST(0.1, 0),
        SOUTH(0, 0.1),
        WEST(-0.1, 0),
        STILL(0, 0);

        private double x;
        private double y;

        Direction(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
