package com.javarush.games.racer;

public class FinishLine extends GameObject {

    private boolean isVisible = false;
    public FinishLine() {
        super(RacerGame.ROADSIDE_WIDTH, -1 * ShapeMatrix.FINISH_LINE.length, ShapeMatrix.FINISH_LINE);
    }

    public void show() {
        isVisible = true;
    }

    public void move(int boost) {
        if (!isVisible)
            return;
        y += boost;
    }

    public boolean isCrossed(PlayerCar playerCar) {
        if (playerCar.y < y)  {
           return true;
        } else {
            return false;
        }
    }
}
