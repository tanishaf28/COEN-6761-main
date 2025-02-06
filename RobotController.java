package com.robot.test;

public class RobotController {
	private int[][] floor;
    public int x, y;
    public boolean penDown;
    public Direction direction;

    public enum Direction {
        NORTH, EAST, SOUTH, WEST;
    }
    public RobotController() {
        // Default initialization
        x = 0;
        y = 0;
        penDown = false;
        direction = Direction.NORTH;
    }

    public void initialize(int n) {
    	if (n <= 0) {
            System.out.println("Grid size must be greater than 0."); //handles if n is negative
            return;
        }
        floor = new int[n][n];
        x = 0;
        y = 0;
        penDown = false;
        direction = Direction.NORTH;
        System.out.println("Initialized " + n + "x" + n + " grid.");
    }

    public void penUp() {
        penDown = false;
        System.out.println("Pen is now up.");
    }

    public void penDown() {
        penDown = true;
        System.out.println("Pen is now down.");
    }

    public void turnRight() {
        switch (direction) {
        case NORTH -> direction = Direction.EAST;
        case EAST -> direction = Direction.SOUTH;
        case SOUTH -> direction = Direction.WEST;
        case WEST -> direction = Direction.NORTH;
    }
        System.out.println("Turned right. Now facing " + direction + ".");
    }

    public void turnLeft() {
        switch (direction) {
        case NORTH -> direction = Direction.WEST;
        case WEST -> direction = Direction.SOUTH;
        case SOUTH -> direction = Direction.EAST;
        case EAST -> direction = Direction.NORTH;
        }
        System.out.println("Turned left. Now facing " + direction + ".");
    }

    public void move(int steps) {
        for (int i = 0; i < steps; i++) {
            switch (direction) {
                case NORTH -> y = Math.min(y + 1, floor.length - 1);
                case SOUTH -> y = Math.max(y - 1, 0);
                case EAST -> x = Math.min(x + 1, floor[0].length - 1);
                case WEST -> x = Math.max(x - 1, 0);
            }
            if (penDown) {
                floor[y][x] = 1;
            }
        }
        System.out.println("Moved " + steps + " steps.");
    }

    public void printFloor() {
        if (floor == null) {
            System.out.println("Error: Grid is not initialized. Please initialize the grid first.");
            return;
        }
        System.out.println("Floor:");
        for (int i = floor.length - 1; i >= 0; i--) {
            for (int j = 0; j < floor[i].length; j++) {
                System.out.print(floor[i][j] == 1 ? "*" : " ");
            }
            }
            System.out.println();
        }
    
    public int[][] getFloor() {
        return floor;
    }

    public void printStatus() {
        System.out.println("Position: [" + x + ", " + y + "] - Pen: " + (penDown ? "down" : "up") + " - Facing: " + direction);
    }
}
