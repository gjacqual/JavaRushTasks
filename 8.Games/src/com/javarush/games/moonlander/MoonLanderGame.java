package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private GameObject landscape;
    private Rocket rocket;
    private int score;

    private boolean  isGameStopped;
    private GameObject platform;

    @Override
    public void onKeyPress(Key key) {
       if (key == key.UP) {
           isUpPressed = true;
       } else if (key == key.LEFT) {
           isLeftPressed = true;
           isRightPressed = false;
       } else if (key == key.RIGHT) {
           isRightPressed = true;
           isLeftPressed = false;
       } else if (key == key.SPACE && isGameStopped) {
           createGame();
       }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == key.UP) {
            isUpPressed = false;
        } else if (key == key.LEFT) {
            isLeftPressed = false;
        } else if (key == key.RIGHT) {
            isRightPressed = false;
        }
    }

    private void createGameObjects() {
        rocket = new Rocket(WIDTH/2, 0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
        platform = new GameObject(23, MoonLanderGame.HEIGHT - 1,
                ShapeMatrix.PLATFORM);
    }

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        showGrid(false);
    }


    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellColor(x, y, Color.DARKBLUE);
            }
        }
        rocket.draw(this);
        landscape.draw(this);
    }

    private void createGame() {
        createGameObjects();
        drawScene();
        setTurnTimer(50);
        isUpPressed = false;
        isLeftPressed = false;
        isRightPressed = false;
        isGameStopped = false;
        score = 1000;
    }

    @Override
    public void onTurn(int step) {
        rocket.move(isUpPressed, isLeftPressed, isRightPressed);
        check();
        if (score > 0) {
            score--;
        }
        setScore(score);
        drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x <= 0 || y <=0 || x > WIDTH-1 || y > HEIGHT - 1)
            return;
        super.setCellColor(x, y, color);
    }

    private void check() {
        if (rocket.isCollision(landscape) && !(rocket.isCollision(platform)
                && rocket.isStopped()))
            gameOver();
        else if (rocket.isCollision(platform) && rocket.isStopped())
            win();
    }

    private void win() {
        rocket.land();
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "YOU WIN!", Color.RED, 75 );
        stopTurnTimer();
    }

    private void gameOver() {
        rocket.crash();
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "GAME OVER", Color.RED, 75 );
        stopTurnTimer();
        score = 0;
    }
}
