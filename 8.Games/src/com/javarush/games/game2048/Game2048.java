package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game2048 extends Game {

    private static final int SIDE = 4;
    private boolean isGameStopped = false;
    private int[][] gameField = new int[SIDE][SIDE];

    private int score = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();

    }

    private void drawScene() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void createNewNumber() {
        if (getMaxTileValue() == 2048)
            win();
        int randomX;
        int randomY;
        do {
            randomX = getRandomNumber(SIDE);
            randomY = getRandomNumber(SIDE);
        } while (gameField[randomX][randomY] != 0);
        
       int randomVal = getRandomNumber(10);
       if (randomVal == 9)
           gameField[randomX][randomY] = 4;
       else
           gameField[randomX][randomY] = 2;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        setCellValueEx(x, y, getColorByValue(value), value == 0 ? "" : String.valueOf(value));
    }

    private Color getColorByValue(int value) {

        switch (value) {
            case 2:
                return Color.GREEN;
            case 4:
                return Color.ORANGE;
            case 8:
                return Color.ALICEBLUE;
            case 16:
                return Color.AZURE;
            case 32:
                return Color.HONEYDEW;
            case 64:
                return Color.PINK;
            case 128:
                return Color.LIGHTGRAY;
            case 256:
                return Color.LIGHTCYAN;
            case 512:
                return Color.LIGHTYELLOW;
            case 1024:
                return Color.LIGHTCORAL;
            case 2048:
                return Color.LIGHTSALMON;
            default:
                return Color.WHITE;
        }
    }

    private boolean compressRow(int[] row) {

        boolean isChanged = false;
        int position = 0;
        
        for (int i = 0; i < row.length; i++) {
            if (row[i] > 0) {
                if (i != position) {
                    row[position] = row[i];
                    row[i] = 0;
                    isChanged = true;
                }
                position++;
            }
        }
        return isChanged;
    }

    private boolean mergeRow(int[] row) {
        boolean isChanged = false;
        for (int i = 0; i < SIDE - 1; i++) {
            if (row[i] > 0)  {
                if (row[i] == row[i+1]) {
                    row[i] = row[i] + row[i+1];
                    row[i + 1] = 0;
                    isChanged = true;
                    score += row[i];
                    setScore(score);
                }
            }
        }
        return isChanged;
    }

    @Override
    public void onKeyPress(Key key) {



        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                createGame();
                drawScene();
                score = 0;
                setScore(score);
            }
        }
        else {

            if (!canUserMove()) {
                gameOver();
                return;
            }

            if (key == Key.LEFT || key == Key.RIGHT || key == Key.UP || key == Key.DOWN) {
                if (key == Key.LEFT) {
                    moveLeft();
                } else if (key == Key.RIGHT) {
                    moveRight();
                } else if (key == Key.UP) {
                    moveUp();
                } else if (key == Key.DOWN) {
                    moveDown();
                }
                drawScene();
            }
        }
    }

    private void moveLeft() {
        boolean isCompressed = false;
        boolean isMerged = false;
        boolean isChanged = false;
        for (int i = 0; i < SIDE; i++) {
            isCompressed = compressRow(gameField[i]);
            isMerged = mergeRow(gameField[i]);
            if (isMerged) {
                compressRow(gameField[i]);
            }
            if (isCompressed || isMerged)
                isChanged = true;
        }
        if (isChanged) {
            createNewNumber();
        }
    }
    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }
    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }
    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] gameRotate = new int[SIDE][SIDE];
        int rotPozX = 0;
        int rotPozY = SIDE - 1;

        for (int[] pozX : gameField) {
            for (int pozY : pozX) {
                gameRotate[rotPozX++][rotPozY] = pozY;
            }
            rotPozX = 0;
            rotPozY--;
        }
         gameField = gameRotate;
    }

    private int getMaxTileValue() {
        int maxVal = 0;
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (gameField[y][x] > maxVal)
                    maxVal = gameField[y][x];
            }
        }
        return maxVal;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "You Win!", Color.RED, 75);
    }

    private boolean canUserMove() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (gameField[y][x] == 0)
                    return true;
            }
        }
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE - 1; y++) {
                if (gameField[y][x] == gameField[y+1][x])
                    return true;
            }
        }
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE - 1; x++) {
                if (gameField[y][x] == gameField[y][x+1])
                    return true;
            }
        }
        return false;
    }
    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "GAME OVER!", Color.RED, 75);
    }
}
