package com.robot.test;

import java.util.Scanner;
public class Main {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        RobotController robot = new RobotController();

	        System.out.println("Robot Simulation. Enter commands ([H|h] for help):");
	        while (true) {
	            String input = scanner.nextLine().trim();
	            String[] parts = input.split(" "); 

	            if (input.equalsIgnoreCase("q")) {
	                System.out.println("Exiting program...");
	                break;
	            } else if (parts[0].equalsIgnoreCase("i") && parts.length > 1) {
	                try {
	                    int size = Integer.parseInt(parts[1]);
	                    robot.initialize(size);
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid grid size. Please enter a valid number.");
	                }
	            } else if (input.equalsIgnoreCase("u")) {
	                robot.penUp();
	            } else if (input.equalsIgnoreCase("d")) {
	                robot.penDown();
	            } else if (input.equalsIgnoreCase("r")) {
	                robot.turnRight();
	            } else if (input.equalsIgnoreCase("l")) {
	                robot.turnLeft();
	            } else if (parts[0].equalsIgnoreCase("m") && parts.length > 1) {
	                try {
	                    int steps = Integer.parseInt(parts[1]);
	                    robot.move(steps);
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid number of steps. Please enter a valid number.");
	                }
	            } else if (input.equalsIgnoreCase("p")) {
	            	robot.printFloor();
	            } else if (input.equalsIgnoreCase("c")) {
	                robot.printStatus();
	            } else if (input.equalsIgnoreCase("h")) {
	                printHelp();
	            } else {
	                System.out.println("Invalid command. Enter [H|h] for help.");
	            }
	        }

	        scanner.close();
	    }

	    private static void printHelp() {
	        System.out.println("[U|u] Pen up");
	        System.out.println("[D|d] Pen down");
	        System.out.println("[R|r] Turn right");
	        System.out.println("[L|l] Turn left");
	        System.out.println("[M s|m s] Move forward s spaces");
	        System.out.println("[P|p] Print the grid");
	        System.out.println("[C|c] Print current status");
	        System.out.println("[I n|i n] Initialize the system");
	        System.out.println("[Q|q] Quit the program");
	    }
}
