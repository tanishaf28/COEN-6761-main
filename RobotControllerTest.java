package com.robot.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotControllerTest {

    private RobotController robot;

    @BeforeEach
    void setUp() {
        robot = new RobotController();
    }

    // Test Initialization
    @Test
    void testInitializeValidGrid() {
        robot.initialize(5);
        assertNotNull(robot.getFloor());
        assertEquals(5, robot.getFloor().length);
    }

    @Test
    void testInitializeInvalidGrid() {
        robot.initialize(0);
        assertNull(robot.getFloor(), "Grid should not initialize if size is less than or equal to 0.");
    }

    // Pen up/down tests
    @Test
    void testPenUp() {
        robot.penUp();
        assertFalse(robot.penDown, "Pen should be up.");
    }

    @Test
    void testPenDown() {
        robot.penDown();
        assertTrue(robot.penDown, "Pen should be down.");
    }

    // Turning tests
    @Test
    void testTurnRightFromNorth() {
        robot.turnRight();
        assertEquals(RobotController.Direction.EAST, robot.direction, "After turning right from North, direction should be East.");
    }

    @Test
    void testTurnRightFromEast() {
        robot.turnRight();
        robot.turnRight();
        assertEquals(RobotController.Direction.SOUTH, robot.direction, "After turning right from East twice, direction should be South.");
    }

    @Test
    void testTurnLeftFromNorth() {
        robot.turnLeft();
        assertEquals(RobotController.Direction.WEST, robot.direction, "After turning left from North, direction should be West.");
    }

    @Test
    void testTurnLeftFromWest() {
        robot.turnLeft();
        robot.turnLeft();
        assertEquals(RobotController.Direction.SOUTH, robot.direction, "After turning left from West twice, direction should be South.");
    }

    // Move tests
    @Test
    void testMoveWithPenUp() {
        robot.initialize(5);
        robot.move(3);
        assertEquals(0, robot.getFloor()[0][3], "With pen up, no cells should be marked.");
    }

    @Test
    void testMoveWithPenDown() {
        robot.initialize(5);
        robot.penDown();
        robot.move(3);
        assertEquals(1, robot.getFloor()[0][3], "With pen down, the floor should be marked after movement.");
    }

    @Test
    void testMoveToEdge() {
        robot.initialize(5);
        robot.move(5);  // Move to the edge
        assertEquals(4, robot.x, "The robot should stop at the edge of the grid.");
        assertEquals(0, robot.y, "The robot should stay within grid bounds.");
    }

    // Print status tests
    @Test
    void testPrintStatus() {
        robot.initialize(5);
        robot.penDown();
        robot.move(3);
        robot.turnRight();
        robot.move(2);
        assertDoesNotThrow(() -> robot.printStatus(), "Printing status should not throw an exception.");
    }

    // Print floor (simple check for output generation)
    @Test
    void testPrintFloor() {
        robot.initialize(5);
        robot.penDown();
        robot.move(2);
        robot.turnRight();
        robot.move(2);
        assertDoesNotThrow(() -> robot.printFloor(), "Floor print should not throw an exception.");
    }

    // Edge case testing
    @Test
    void testMoveBeyondBounds() {
        robot.initialize(5);
        robot.move(10);  // Move beyond the grid
        assertEquals(4, robot.x, "The robot should not move beyond the grid's width.");
        assertEquals(0, robot.y, "The robot should not move beyond the grid's height.");
    }
}
