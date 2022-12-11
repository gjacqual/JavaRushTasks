package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;

    private static final int STEP = ShapeMatrix.ENEMY.length + 1;

    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public double getBottomBorder() {

        double maximum = Integer.MIN_VALUE;

        for (EnemyShip ship : ships) {
            if (ship.y + ship.height > maximum)
                maximum = ship.y + ship.height;
        }
        return maximum;
    }

    private double getSpeed() {
       return Math.min(2.0, 3.0 / ships.size());
    }

    public void move() {
        int flag = -1;

        if (ships.size() < 1)
            return;
        if (direction == Direction.LEFT && getLeftBorder() < 0) {
            direction = Direction.RIGHT;
            flag = 1;
        } else if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
            direction = Direction.LEFT;
            flag = 1;
        }
        double speed = getSpeed();

        if (flag == 1) {
            for (EnemyShip ship : ships) {
                ship.move(Direction.DOWN, speed);
            }
        } else {
            for (EnemyShip ship : ships) {
                ship.move(direction,speed);
            }
        }
    }

    public EnemyFleet() {
        createShips();
    }
    private void createShips() {
        ships = new ArrayList<EnemyShip>();
        for (int y = 0; y < ROWS_COUNT; y++) {
            for (int x = 0; x < COLUMNS_COUNT; x++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 -
                ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
        
    }

    public void draw(Game game) {
        for (EnemyShip ship : ships) {
            ship.draw(game);
        }
    }

    private double getLeftBorder() {
        double minimum = Integer.MAX_VALUE;
        for (EnemyShip enemyShip : ships) {
            if (enemyShip.x < minimum)
                minimum = enemyShip.x;
        }
        return minimum;
    }

    private double getRightBorder() {
        double maximum = Integer.MIN_VALUE;
        for (EnemyShip enemyShip : ships) {
            if (enemyShip.x + enemyShip.width > maximum)
                maximum = enemyShip.x + enemyShip.width;
        }
        return maximum;
    }
    public Bullet fire(Game game) {
        if (ships.size() == 0)
            return null;
        double res = game.getRandomNumber(100/ SpaceInvadersGame.COMPLEXITY);
        if (res > 0)
            return null;
        return ships.get(game.getRandomNumber(ships.size())).fire();
    }
    public int verifyHit(List<Bullet> bullets) {
        if (bullets.size() == 0)
            return  0;

        int score = 0;
        Iterator<EnemyShip> it = ships.iterator();
        while(it.hasNext()) {
            EnemyShip nextEnemyShip = it.next();
            Iterator<Bullet> itBullet = bullets.iterator();
            while(itBullet.hasNext()) {
                Bullet nextBullet = itBullet.next();
                if (nextBullet.isCollision(nextEnemyShip) && nextEnemyShip.isAlive && nextBullet.isAlive) {
                    score += nextEnemyShip.score;
                    nextBullet.kill();
                    nextEnemyShip.kill();
                }
            }
        }
       

        return score;
    }

    public void deleteHiddenShips() {
        Iterator<EnemyShip> it = ships.iterator();
        while(it.hasNext()) {
            EnemyShip nextEnemyShip = it.next();
            if (!nextEnemyShip.isVisible()) {
                it.remove();
            }

        }
    }

    public int getShipsCount() {
        return ships.size();
    }


}
