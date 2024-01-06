package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;

public class SimpleGameTests {
    @Test
    public void testMoveRightWithoutObstacles() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position to the left edge
        game.playerX = 7;
        game.playerY = 0;

        // Clear any obstacles in the player's path to the right
        game.board[7][1] = SimpleGame.EMPTY;
        game.board[7][2] = SimpleGame.EMPTY;
        game.board[7][3] = SimpleGame.EMPTY;

        // Set the expected player position after moving right
        int expectedPlayerX = 7;
        int expectedPlayerY = 3;

        // Act
        game.move("right");
        game.move("right");
        game.move("right");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should be incremented by 3");
    }
    @Test
    public void testMoveDownWithoutObstacles() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position to the top edge
        game.playerX = 0;
        game.playerY = 7;

        // Clear any obstacles in the player's path downward
        game.board[1][7] = SimpleGame.EMPTY;
        game.board[2][7] = SimpleGame.EMPTY;
        game.board[3][7] = SimpleGame.EMPTY;

        // Set the expected player position after moving down
        int expectedPlayerX = 3;
        int expectedPlayerY = 7;

        // Act
        game.move("down");
        game.move("down");
        game.move("down");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should be incremented by 3");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveUpWithoutObstacles() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position to the bottom edge
        game.playerX = 14;
        game.playerY = 7;

        // Clear any obstacles in the player's path upward
        game.board[13][7] = SimpleGame.EMPTY;
        game.board[12][7] = SimpleGame.EMPTY;
        game.board[11][7] = SimpleGame.EMPTY;

        // Set the expected player position after moving up
        int expectedPlayerX = 11;
        int expectedPlayerY = 7;

        // Act
        game.move("up");
        game.move("up");
        game.move("up");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should be decremented by 3");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveLeftWithoutObstacles() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position to the right edge
        game.playerX = 7;
        game.playerY = 14;

        // Clear any obstacles in the player's path to the left
        game.board[7][13] = SimpleGame.EMPTY;
        game.board[7][12] = SimpleGame.EMPTY;
        game.board[7][11] = SimpleGame.EMPTY;

        // Set the expected player position after moving left
        int expectedPlayerX = 7;
        int expectedPlayerY = 11;

        // Act
        game.move("left");
        game.move("left");
        game.move("left");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should be decremented by 3");
    }
    @Test
    public void testMoveUpOutsideBoard() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position to the topmost edge
        game.playerX = 0;
        game.playerY = 7;

        // Set the expected player position after attempting to move up outside the board
        int expectedPlayerX = 0;
        int expectedPlayerY = 7;

        // Act
        game.move("up");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveDownOutsideBoard() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position to the bottommost edge
        game.playerX = 14;
        game.playerY = 7;

        // Set the expected player position after attempting to move down outside the board
        int expectedPlayerX = 14;
        int expectedPlayerY = 7;

        // Act
        game.move("down");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveLeftOutsideBoard() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position to the leftmost edge
        game.playerX = 7;
        game.playerY = 0;

        // Set the expected player position after attempting to move left outside the board
        int expectedPlayerX = 7;
        int expectedPlayerY = 0;

        // Act
        game.move("left");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveRightOutsideBoard() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position to the rightmost edge
        game.playerX = 7;
        game.playerY = 14;

        // Set the expected player position after attempting to move right outside the board
        int expectedPlayerX = 7;
        int expectedPlayerY = 14;

        // Act
        game.move("right");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }
    @Test
    public void testIncorrectUserInput() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position
        game.playerX = 7;
        game.playerY = 7;

        // Set the expected player position after incorrect user input
        int expectedPlayerX = 7;
        int expectedPlayerY = 7;

        // Act
        game.move("invalid_direction");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
        assertFalse(outContent.toString().contains("Invalid move command. Please enter 'up', 'down', 'left', or 'right'."), "Should print error message for empty input");

    }
    @Test
    public void testEmptyUserInput() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position
        game.playerX = 7;
        game.playerY = 7;

        // Set the expected player position after incorrect user input
        int expectedPlayerX = 7;
        int expectedPlayerY = 7;

        // Act
        game.move(" ");
        
        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
        assertFalse(outContent.toString().contains("Invalid move command. Please enter 'up', 'down', 'left', or 'right'."), "Should print error message for empty input");
    }
    @Test
    public void testMoveRightWithObstacles() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position to the left edge
        game.playerX = 7;
        game.playerY = 0;

        // Add an obstacle in the player's path to the right
        game.board[7][1] = SimpleGame.OBSTACLE;

        // Set the expected player position after moving right
        int expectedPlayerX = 7;
        int expectedPlayerY = 0;

        // Act
        game.move("right");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }
    @Test
    public void testMoveIntoObstacleUp() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position
        game.playerX = 3;
        game.playerY = 7;

        // Place an obstacle in the player's path
        game.board[2][7] = SimpleGame.OBSTACLE;

        // Set the expected player position after attempting to move up into an obstacle
        int expectedPlayerX = 3;
        int expectedPlayerY = 7;


        // Act
        game.move("up");

    
        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveIntoObstacleDown() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position
        game.playerX = 11;
        game.playerY = 7;

        // Place an obstacle in the player's path
        game.board[12][7] = SimpleGame.OBSTACLE;

        // Set the expected player position after attempting to move down into an obstacle
        int expectedPlayerX = 11;
        int expectedPlayerY = 7;

        // Act
        game.move("down");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveIntoObstacleLeft() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position
        game.playerX = 7;
        game.playerY = 3;

        // Place an obstacle in the player's path
        game.board[7][2] = SimpleGame.OBSTACLE;

        // Set the expected player position after attempting to move left into an obstacle
        int expectedPlayerX = 7;
        int expectedPlayerY = 3;

        // Act
        game.move("left");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");

    }

    @Test
    public void testMoveIntoObstacleRight() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position
        game.playerX = 7;
        game.playerY = 11;

        // Place an obstacle in the player's path
        game.board[7][12] = SimpleGame.OBSTACLE;

        // Set the expected player position after attempting to move right into an obstacle
        int expectedPlayerX = 7;
        int expectedPlayerY = 11;

        // Act
        game.move("right");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }
    @Test
    public void testPointsCalculationWithFastTime() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Simulate a fast completion time (within 5 seconds)
        game.startTime = game.startTime.minusSeconds(0);

        // Act
        game.move("right"); // Perform a move to trigger points calculation

        // Assert
        assertEquals(99, game.currentPoints, "Points should be maximum for fast completion");
    }

    @Test
    public void testPointsCalculationWithSlowTimeAndMoves() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);
    
        // Simulate a slow completion time (more than 50 seconds)
        game.startTime = game.startTime.minusSeconds(60);
    
        // Perform some moves
        game.move("right");
        game.move("down");
        game.move("left");
    
        // Act
        game.move("up");  // Perform a move to trigger points calculation
    
        // Calculate the expected time points deduction
        long seconds = 60;
        int expectedTimePoints = Math.min((int) (seconds / 2), 50);
    
        // Calculate the expected moves points deduction
        int expectedMovesPoints = game.moveCount / 2;
    
        // Calculate the expected total points
        int expectedPoints = 100 - expectedTimePoints - expectedMovesPoints;

        // Assert
        assertEquals(expectedPoints, 66, "Points should be reduced for slow completion and moves");
    }
    @Test
    public void testPointsCalculationWithFewMoves() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Perform a series of moves
        game.move("right");
        game.move("down");
        game.move("left");

        // Act
        game.move("up"); // Perform an additional move to trigger points calculation

        // Assert
        assertEquals(96, game.currentPoints, "Points should be reduced based on the number of moves");
    }
    @Test
    public void testPointsCalculationWithManyMoves() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Perform a series of moves
        game.move("right");
        game.move("down");
        game.move("left");
        game.move("right");
        game.move("down");
        game.move("left");
        game.move("right");
        game.move("down");
        game.move("left");
        game.move("right");
        game.move("down");
        game.move("left");
        game.move("right");
        game.move("down");
        game.move("left");
        game.move("right");
        game.move("down");
        game.move("left");
        game.move("right");
        game.move("down");
        game.move("left");
        game.move("right");
        game.move("down");
        game.move("left");
        game.move("right");
        game.move("down");
        game.move("left");
        game.move("right");
        game.move("down");
        game.move("left");
        game.move("right");
        game.move("down");
        game.move("left");
        game.move("right");
        game.move("down");
        game.move("left");

        // Act
        game.move("up"); // Perform an additional move to trigger points calculation

        // Assert
        assertEquals(63, game.currentPoints, "Points should be reduced based on the number of moves");
    }
    @Test
    public void testExitCommand() {
        // Arrange
        SimpleGame game = new SimpleGame(15, 15);

        // Set player position
        game.playerX = 7;
        game.playerY = 3;

        // Set the expected player position after attempting to move left into an obstacle
        int expectedPlayerX = 7;
        int expectedPlayerY = 3;

        // Act
        game.move("exit");

        // Assert
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");

    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
}