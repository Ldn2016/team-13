package banter.demmaze;

import java.io.Serializable;

public class Maze implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;

    private boolean[][] verticalLines;
    private boolean[][] horizontalLines;
    private int sizeX, sizeY;         //stores the width and height of the maze
    private int currentX, currentY;   //stores the current location of the ball
    private int finalX, finalY;       //stores the finishing point of the maze
    private boolean gameComplete;

    //setters and getters

    public boolean move(int direction) {
        boolean moved = false;
        if(direction == UP) {
            if(currentY != 0 && !horizontalLines[currentY-1][currentX]) {
                currentY--;
                moved = true;
            }
        }
        if(direction == DOWN) {
            if(currentY != sizeY-1 && !horizontalLines[currentY][currentX]) {
                currentY++;
                moved = true;
            }
        }
        if(direction == RIGHT) {
            if(currentX != sizeX-1 && !verticalLines[currentY][currentX]) {
                currentX++;
                moved = true;
            }
        }
        if(direction == LEFT) {
            if(currentX != 0 && !verticalLines[currentY][currentX-1]) {
                currentX--;
                moved = true;
            }
        }
        if(moved) {
            if(currentX == finalX && currentY == finalY) {
                gameComplete = true;
            }
        }
        return moved;
    }

    public void setCurrentPosition(int x, int y) {
        this.currentX = x;
        this.currentY = y;
    }

    public void setFinalPosition(int x, int y) {
        this.finalX = x;
        this.finalY = y;
    }

    public void setVerticalLines(boolean[][] verticalLines) {
        this.verticalLines = verticalLines;
    }

    public void setHorizontalLines(boolean[][] horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public boolean isGameComplete() {
        return gameComplete;
    }

    public void setGameComplete(boolean gameComplete) {
        this.gameComplete = gameComplete;
    }

    public int getFinalX() {
        return finalX;
    }

    public int getFinalY() {
        return finalY;
    }

}
