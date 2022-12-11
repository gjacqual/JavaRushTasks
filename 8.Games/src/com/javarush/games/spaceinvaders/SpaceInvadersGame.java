package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    public static final int COMPLEXITY = 5;
    private List<Bullet> enemyBullets;
    private PlayerShip playerShip;
    private boolean isGameStopped;
    private int animationsCount;
    private  List<Bullet> playerBullets;
    private static final int PLAYER_BULLETS_MAX = 1;

    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        createStars();
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<Bullet>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        playerBullets = new ArrayList<Bullet>();
        drawScene();
        setTurnTimer(40);
        score = 0;
    }

    private void drawScene() {
        drawField();
        playerShip.draw(this);
        enemyFleet.draw(this);

        for (Bullet enemyBullet : enemyBullets) {
            enemyBullet.draw(this);
        }
        for (Bullet playerBullet : playerBullets) {
            playerBullet.draw(this);
        }

    }
    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK,"");
            }
        }
        for(Star star : stars) {
            star.draw(this);
        }
    }

    private void createStars() {
        stars = new ArrayList<Star>();
        stars.add(new Star(10, 20));
        stars.add(new Star(15, 25));
        stars.add(new Star(20, 35));
        stars.add(new Star(25, 45));
        stars.add(new Star(30, 55));
        stars.add(new Star(34, 60));
        stars.add(new Star(40, 15));
        stars.add(new Star(55, 10));
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet enemyBullet = enemyFleet.fire(this);
        if (enemyBullet != null) {
            enemyBullets.add(enemyBullet);
        }
        setScore(score);
        drawScene();
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        for (Bullet enemyBullet : enemyBullets) {
            enemyBullet.move();
        }
        for (Bullet playerBullet : playerBullets) {
            playerBullet.move();
        }
        playerShip.move();
    }

    private void removeDeadBullets() {
        Iterator<Bullet> it = enemyBullets.iterator();
        while(it.hasNext()) {
            Bullet nextBullet = it.next();
            if (!nextBullet.isAlive || nextBullet.y >= (HEIGHT - 1)) {
                it.remove();
            }
        }
        Iterator<Bullet> itPlayerBullets = playerBullets.iterator();
        while(itPlayerBullets.hasNext()) {
            Bullet nextPBullet = itPlayerBullets.next();
            if (!nextPBullet.isAlive || (nextPBullet.y + nextPBullet.height) < 0) {
                itPlayerBullets.remove();
            }
        }


    }

    private void check() {
        playerShip.verifyHit(enemyBullets);
        score += enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();
        if (!playerShip.isAlive) {
            stopGameWithDelay();
        }
        if (enemyFleet.getBottomBorder() >= playerShip.y) {
            playerShip.kill();
        }
        if (enemyFleet.getShipsCount() == 0) {
            playerShip.win();
            stopGameWithDelay();
        }

    }

    private void stopGame(boolean isWin) {
       isGameStopped = true;
       stopTurnTimer();
       if (isWin) {
           showMessageDialog(Color.BLACK, "YOU WIN!", Color.GREEN, 65);
       } else {
           showMessageDialog(Color.BLACK, "GAME OVER!", Color.RED, 65);
       }
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10)
            stopGame(playerShip.isAlive);
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped) {
            createGame();
        } else if (key == Key.SPACE) {
            Bullet result = playerShip.fire();
            if (result != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                playerBullets.add(result);
            }
        } else if (key == Key.LEFT) {
            playerShip.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            playerShip.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) {
            playerShip.setDirection(Direction.UP);
        } else if (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT) {
            playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x < 0 || x > WIDTH - 1 || y < 0 || y > WIDTH - 1 ) {
            return;
        }
        super.setCellValueEx(x, y, cellColor, value);
    }
}
