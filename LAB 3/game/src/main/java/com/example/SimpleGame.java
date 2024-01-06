package com.example;
import java.util.Random;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

public class SimpleGame {
    static final char EMPTY = '.';
    private static final char START = 'A';
    private static final char STOP = 'B';
    static final char OBSTACLE = 'X';
    private static final char PLAYER = 'P';

    char[][] board;
    private int startX, startY, stopX, stopY;
    int playerX;
    int playerY;
    Instant startTime;
    int currentPoints;
    int moveCount;
    private boolean shouldExit = false;

    public SimpleGame(int rows, int columns) {
        initializeBoard(rows, columns);
        placeStartAndStop();
        placeObstacles();
        placePlayer();
        startTime = Instant.now();
        currentPoints = 100; // Start with zero points
        moveCount = 0;
        System.out.println("Welcome! Your goal is to reach point B marked on the game board :)");
        System.out.println("Scoring system:");
        System.out.println("You are starting with 100 points");
        System.out.println("- 1 point deducted for each move");
        System.out.println("- 1 point deducted for each move (up to 50 points)");
        System.out.println("Try to reach the destination with as many points as possible!");
    }

    private void initializeBoard(int rows, int columns) {
        board = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private void placeStartAndStop() {
        Random random = new Random();

        // Place START
        startX = random.nextInt(board.length);
        startY = random.nextInt(board[0].length);
        board[startX][startY] = START;

        // Place STOP
        do {
            stopX = random.nextInt(board.length);
            stopY = random.nextInt(board[0].length);
        } while ((stopX == startX && stopY == startY) || board[stopX][stopY] == OBSTACLE || Math.abs(stopX - startX) < 4);

        board[stopX][stopY] = STOP;
    }

    private void placeObstacles() {
        Random random = new Random();
        int obstacleCount = board.length * board[0].length / 4; // Adjust the obstacle density

        for (int i = 0; i < obstacleCount; i++) {
            int obstacleX, obstacleY;

            // Place obstacle, ensuring it's not at START, STOP, or another obstacle
            do {
                obstacleX = random.nextInt(board.length);
                obstacleY = random.nextInt(board[0].length);
            } while ((obstacleX == startX && obstacleY == startY) ||
                    (obstacleX == stopX && obstacleY == stopY) ||
                    board[obstacleX][obstacleY] == OBSTACLE);

            board[obstacleX][obstacleY] = OBSTACLE;
        }
    }

    private void placePlayer() {
        playerX = startX;
        playerY = startY;
        board[playerX][playerY] = PLAYER;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void move(String direction) {
        board[playerX][playerY] = EMPTY; // Clear current position
    
        switch (direction.toLowerCase()) {
            case "up":
                if (playerX > 0) {
                    if (board[playerX - 1][playerY] == OBSTACLE) {
                        System.out.println("Oops! You moved into an obstacle. Try another direction.");
                    } else {
                        playerX--;
                    }
                } else {
                    System.out.println("Oops! You cannot move up. Try another direction.");
                }
                break;
            case "down":
                if (playerX < board.length - 1) {
                    if (board[playerX + 1][playerY] == OBSTACLE) {
                        System.out.println("Oops! You moved into an obstacle. Try another direction.");
                    } else {
                        playerX++;
                    }
                } else {
                    System.out.println("Oops! You cannot move down. Try another direction.");
                }
                break;
            case "left":
                if (playerY > 0) {
                    if (board[playerX][playerY - 1] == OBSTACLE) {
                        System.out.println("Oops! You moved into an obstacle. Try another direction.");
                    } else {
                        playerY--;
                    }
                } else {
                    System.out.println("Oops! You cannot move left. Try another direction.");
                }
                break;
            case "right":
                if (playerY < board[0].length - 1) {
                    if (board[playerX][playerY + 1] == OBSTACLE) {
                        System.out.println("Oops! You moved into an obstacle. Try another direction.");
                    } else {
                        playerY++;
                    }
                } else {
                    System.out.println("Oops! You cannot move right. Try another direction.");
                }
                break;
            case "exit":
                System.out.println("Game ended. Thanks for playing!");
                shouldExit = true;
                break;
            default:
                System.out.println("Invalid move command. Please enter 'up', 'down', 'left', or 'right'.");
                board[playerX][playerY] = PLAYER;
                return;
        }
        if (shouldExit) {
            // Exit the method without calling System.exit(0)
            return;
        }
    
        // Check if the player reached the STOP point
        if (playerX == stopX && playerY == stopY) {
            Instant endTime = Instant.now();
            Duration duration = Duration.between(startTime, endTime);
            long seconds = duration.getSeconds();
            int startingPoints = 100;
            int timePoints = Math.min((int) (seconds / 2), 50);
            currentPoints = startingPoints - timePoints;
    
            currentPoints -= (moveCount / 2); // Deduct points for moves
            currentPoints = Math.max(currentPoints, 0);
    
            System.out.println("Congratulations! You reached the destination.");
            System.out.println("Time taken: " + seconds + " seconds");
            System.out.println("Negative points for time: " + timePoints);
            System.out.println("Move count: " + moveCount);
            System.out.println("Negative points for moves: " + (moveCount / 2));
            System.out.println("Total points: " + currentPoints);
            displayGrade(currentPoints);
    
            System.exit(0);
        }
    
        // Update new position
        board[playerX][playerY] = PLAYER;
    
        // Subtract points for each move
        moveCount++;
        currentPoints = Math.max(currentPoints - 1, 0);
    
        // Check if the player reached the STOP point
        if (playerX == stopX && playerY == stopY) {
            Instant endTime = Instant.now();
            Duration duration = Duration.between(startTime, endTime);
            long seconds = duration.getSeconds();
            int startingPoints = 100;
            int timePoints = Math.min((int) (seconds / 2), 50);
            currentPoints = startingPoints - timePoints;
    
            currentPoints -= (moveCount / 2); // Deduct points for moves
            currentPoints = Math.max(currentPoints, 0);
    
            System.out.println("Congratulations! You reached the destination.");
            System.out.println("Time taken: " + seconds + " seconds");
            System.out.println("Negative points for time: " + timePoints);
            System.out.println("Move count: " + moveCount);
            System.out.println("Negative points for moves: " + (moveCount / 2));
            System.out.println("Total points: " + currentPoints);
            displayGrade(currentPoints);
    
            System.exit(0);
        }
    
        // Update new position
        board[playerX][playerY] = PLAYER;
    
        // Subtract points for each move
        moveCount++;
    }
    private void displayGrade(int points) {
        if (points >= 90) {
            System.out.println("Grade: A");
        } else if (points >= 80) {
            System.out.println("Grade: B");
        } else if (points >= 70) {
            System.out.println("Grade: C");
        } else if (points >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }

    public static void main(String[] args) {
        SimpleGame game = new SimpleGame(15, 15);
        game.printBoard();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter direction (up/down/left/right) or 'exit' to end: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Game ended. Thanks for playing!");
                break;
            }

            game.move(input);
            game.printBoard();
        }
        scanner.close();
    }
}