package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;
    private List<GameObject> snakeParts = new ArrayList<>();
    public Snake(int x, int y) {

        for(int i = 0; i < 3; i++) {
            snakeParts.add(new GameObject(x+i, y));
        }
    }

    public void draw(Game game) {
        game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE,
                HEAD_SIGN, isAlive ? Color.BLACK : Color.RED, 75);
        for (int i = 1; i < snakeParts.size(); i++) {
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y,
                    Color.NONE, BODY_SIGN, isAlive ? Color.BLACK : Color.RED, 75);
        }
    }

    public void setDirection(Direction direction) {
        if (this.direction == Direction.LEFT
                && snakeParts.get(0).x == snakeParts.get(1).x) {
            return;
        }
        if (this.direction == Direction.RIGHT
                && snakeParts.get(0).x == snakeParts.get(1).x) {
            return;
        }
        if (this.direction == Direction.UP
                && snakeParts.get(0).y == snakeParts.get(1).y) {
            return;
        }
        if (this.direction == Direction.DOWN
                && snakeParts.get(0).y == snakeParts.get(1).y) {
            return;
        }

        if (this.direction == Direction.UP && direction == Direction.DOWN) {
            return;
        }
        if (this.direction == Direction.DOWN && direction == Direction.UP) {
            return;
        }
        if (this.direction == Direction.LEFT && direction == Direction.RIGHT) {
            return;
        }
        if (this.direction == Direction.RIGHT && direction == Direction.LEFT) {
            return;
        }
        this.direction = direction;
    }

    public void move(Apple apple) {

        GameObject newHead = createNewHead();
        if (newHead.x < 0 || newHead.y < 0 || newHead.x >= SnakeGame.WIDTH
                || newHead.y >= SnakeGame.HEIGHT) {
            isAlive = false;
            return;
        }
        if (checkCollision(newHead)) {
            isAlive = false;
            return;
        }
        snakeParts.add(0, newHead);

        if (newHead.x == apple.x && newHead.y == apple.y) {
            apple.isAlive = false;
        } else {
            removeTail();
        }
    }

    public GameObject createNewHead() {

        int headX = snakeParts.get(0).x;
        int headY = snakeParts.get(0).y;
        if (direction == Direction.LEFT)
            return new GameObject(headX-1, headY);
        else if (direction == Direction.RIGHT)
            return new GameObject(headX+1, headY);
        else if (direction == Direction.UP)
            return new GameObject(headX, headY-1);
        else if (direction == Direction.DOWN)
            return new GameObject(headX, headY+1);
        return new GameObject(headX-1, headY);
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size()-1);
    }

    public boolean checkCollision(GameObject object) {

        for (GameObject part : snakeParts) {
            if (object.x == part.x && object.y == part.y) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }

}
