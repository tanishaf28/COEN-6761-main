# COEN-6761-main
**Robot Controller Project**

Objective
The objective of this project is to implement a software solution that simulates a robot navigating a room, equipped with a pen that can be raised or lowered, and controlled via a set of commands. The project tests the practical use of software testing techniques and helps understand the process of testing robotic movements, pen actions, and various user commands. 

Project Description
This project simulates a robot that moves around a room represented by an **N x N array** (grid), with the robot’s actions and position being controlled by user commands. The robot can perform different operations such as moving in different directions, turning, raising or lowering the pen, and printing the current floor status or its own position.

Features
The room is initially a grid where all values are set to `0` (empty), and the robot starts at the top-left corner (`[0, 0]`). The robot moves around based on commands and either traces a path with its pen or moves without leaving a trace. 

Robot Commands:
- Pen Control:
  [U|u] – Pen up (stops tracing paths)
  [D|d]– Pen down (starts tracing paths)
  
  Movement Control:
  [R|r]– Turn right (90 degrees)
  [L|l] – Turn left (90 degrees)
  [M s|m s] – Move forward `s` spaces (where `s` is a non-negative integer)
  
Display Control:
 [P|p] – Print the N x N array and display the indices of the grid
 [C|c] – Print the current position of the pen, its status (up or down), and the robot's facing direction

System Control:
  [Q|q]– Quit the program
  [I n|i n] – Initialize the grid with size `n`, resetting the robot’s position, pen state, and direction.
  [H|h]– Replay all the steps from the last system initialization or command history.

Robot Movement and Pen Control:
The robot's movement follows these steps:
- Initially, the robot starts at position `[0, 0]`, with the pen up and facing North.
- It can move forward, and if the pen is down, it traces a path on the floor.
- The robot can also turn left or right to change its facing direction.

Setup
- To start the robot simulation, use the `[I n]` command to initialize the system with a grid of size `n x n`.
- The robot starts at position `[0, 0]` and the pen is in the up position by default.
- You can give various commands to control its movement, pen, and direction.

Commands:
1. Initialization:
   - `[I 5]` - Initialize a 5x5 grid, reset the robot's position, pen state, and direction.
   
2. Movement and Pen Control:
   - `[M 3]` - Move the robot 3 spaces forward.
   - `[D]` - Put the pen down (start tracing).
   - `[M 2]` - Move forward 2 spaces while tracing a path.

3. Turn and Direction Control:
   - `[R]` - Turn the robot right (clockwise).
   - `[L]` - Turn the robot left (counter-clockwise).

4. Status and Floor Print:
   - `[P]` - Print the current floor.
   - `[C]` - Print the robot's current status, including position and facing direction.

5. Quit and Exit:
   - `[Q]` - Quit the program.

Testing Approach
The software will include unit tests to validate the behavior of the robot’s movements, pen states, and system commands. These tests will cover all commands, ensuring that the robot behaves as expected in different scenarios.

Technologies Used
- Java: The primary language used to implement the robot simulation.
- JUnit: Used for unit testing the various components of the robot controller.

Repository Structure
- RobotController.java – Contains the robot control logic.
- Main.java- Main class
- RobotControllerTest.java – JUnit test cases for validating robot behavior.
-readme.md– Project description and setup instructions.

