package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;

public class SimpleGameTests {
    @Test
    public void testMoveRightWithoutObstacles() {
        
        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 7;
        game.playerY = 0;

        game.board[7][1] = SimpleGame.EMPTY;
        game.board[7][2] = SimpleGame.EMPTY;
        game.board[7][3] = SimpleGame.EMPTY;

        int expectedPlayerX = 7;
        int expectedPlayerY = 3;
        
        game.move("right");
        game.move("right");
        game.move("right");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should be incremented by 3");
    }
    @Test
    public void testMoveDownWithoutObstacles() {

        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 0;
        game.playerY = 7;

        game.board[1][7] = SimpleGame.EMPTY;
        game.board[2][7] = SimpleGame.EMPTY;
        game.board[3][7] = SimpleGame.EMPTY;

        int expectedPlayerX = 3;
        int expectedPlayerY = 7;

        game.move("down");
        game.move("down");
        game.move("down");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should be incremented by 3");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveUpWithoutObstacles() {
        
        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 14;
        game.playerY = 7;

        game.board[13][7] = SimpleGame.EMPTY;
        game.board[12][7] = SimpleGame.EMPTY;
        game.board[11][7] = SimpleGame.EMPTY;

        int expectedPlayerX = 11;
        int expectedPlayerY = 7;
        
        game.move("up");
        game.move("up");
        game.move("up");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should be decremented by 3");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveLeftWithoutObstacles() {

        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 7;
        game.playerY = 14;

        game.board[7][13] = SimpleGame.EMPTY;
        game.board[7][12] = SimpleGame.EMPTY;
        game.board[7][11] = SimpleGame.EMPTY;

        int expectedPlayerX = 7;
        int expectedPlayerY = 11;

        game.move("left");
        game.move("left");
        game.move("left");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should be decremented by 3");
    }
    @Test
    public void testMoveUpOutsideBoard() {

        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 0;
        game.playerY = 7;

        int expectedPlayerX = 0;
        int expectedPlayerY = 7;

        game.move("up");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveDownOutsideBoard() {

        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 14;
        game.playerY = 7;

        int expectedPlayerX = 14;
        int expectedPlayerY = 7;

        game.move("down");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveLeftOutsideBoard() {

        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 7;
        game.playerY = 0;

        int expectedPlayerX = 7;
        int expectedPlayerY = 0;

        game.move("left");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveRightOutsideBoard() {

        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 7;
        game.playerY = 14;

        int expectedPlayerX = 7;
        int expectedPlayerY = 14;

        game.move("right");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }
    @Test
    public void testIncorrectUserInput() {

        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 7;
        game.playerY = 7;

        int expectedPlayerX = 7;
        int expectedPlayerY = 7;

        game.move("invalid_direction");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
        assertFalse(outContent.toString().contains("Invalid move command. Please enter 'up', 'down', 'left', or 'right'."), "Should print error message for empty input");

    }
    @Test
    public void testEmptyUserInput() {

        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 7;
        game.playerY = 7;

        int expectedPlayerX = 7;
        int expectedPlayerY = 7;

        game.move(" ");
        
        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
        assertFalse(outContent.toString().contains("Invalid move command. Please enter 'up', 'down', 'left', or 'right'."), "Should print error message for empty input");
    }
    @Test
    public void testMoveRightWithObstacles() {
        
        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 7;
        game.playerY = 0;

        game.board[7][1] = SimpleGame.OBSTACLE;

        int expectedPlayerX = 7;
        int expectedPlayerY = 0;

        game.move("right");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }
    @Test
    public void testMoveIntoObstacleUp() {

        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 3;
        game.playerY = 7;

        game.board[2][7] = SimpleGame.OBSTACLE;

        int expectedPlayerX = 3;
        int expectedPlayerY = 7;

        game.move("up");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveIntoObstacleDown() {

        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 11;
        game.playerY = 7;

        game.board[12][7] = SimpleGame.OBSTACLE;

        int expectedPlayerX = 11;
        int expectedPlayerY = 7;

        game.move("down");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }

    @Test
    public void testMoveIntoObstacleLeft() {
        
        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 7;
        game.playerY = 3;

        game.board[7][2] = SimpleGame.OBSTACLE;

        int expectedPlayerX = 7;
        int expectedPlayerY = 3;

        game.move("left");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");

    }

    @Test
    public void testMoveIntoObstacleRight() {

        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 7;
        game.playerY = 11;

        game.board[7][12] = SimpleGame.OBSTACLE;

        int expectedPlayerX = 7;
        int expectedPlayerY = 11;

        game.move("right");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");
    }
    @Test
    public void testPointsCalculationWithFastTime() {

        SimpleGame game = new SimpleGame(15, 15);

        game.startTime = game.startTime.minusSeconds(0);

        game.move("right");

        assertEquals(99, game.currentPoints, "Points should be maximum for fast completion");
    }

    @Test
    public void testPointsCalculationWithSlowTimeAndMoves() {

        SimpleGame game = new SimpleGame(15, 15);

        game.startTime = game.startTime.minusSeconds(60);
    
        game.move("right");
        game.move("down");
        game.move("left");
    
        game.move("up");
    
        long seconds = 60;
        int expectedTimePoints = Math.min((int) (seconds / 2), 50);
    
        int expectedMovesPoints = game.moveCount / 2;
    
        int expectedPoints = 100 - expectedTimePoints - expectedMovesPoints;

        assertEquals(expectedPoints, 66, "Points should be reduced for slow completion and moves");
    }
    @Test
    public void testPointsCalculationWithFewMoves() {
        
        SimpleGame game = new SimpleGame(15, 15);

        game.move("right");
        game.move("down");
        game.move("left");

        game.move("up");

        assertEquals(96, game.currentPoints, "Points should be reduced based on the number of moves");
    }
    @Test
    public void testPointsCalculationWithManyMoves() {

        SimpleGame game = new SimpleGame(15, 15);

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

        game.move("up");

        assertEquals(63, game.currentPoints, "Points should be reduced based on the number of moves");
    }
    @Test
    public void testExitCommand() {
        
        SimpleGame game = new SimpleGame(15, 15);

        game.playerX = 7;
        game.playerY = 3;

        int expectedPlayerX = 7;
        int expectedPlayerY = 3;

        game.move("exit");

        assertEquals(expectedPlayerX, game.playerX, "Player X position should remain unchanged");
        assertEquals(expectedPlayerY, game.playerY, "Player Y position should remain unchanged");

    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
}
