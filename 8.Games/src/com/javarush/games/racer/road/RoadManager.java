package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.GameObject;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;

    private static final int FIRST_LANE_POSITION = 16;

    private static final int FOURTH_LANE_POSITION = 44;

    private List<RoadObject> items = new ArrayList<>();

    private static final int PLAYER_CAR_DISTANCE = 12;

    private int passedCarsCount = 0;

    private void addRoadObject(RoadObjectType type, Game game) {
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject item = createRoadObject(type, x, y);
        if (item != null && isRoadSpaceFree(item)) {
            items.add(item);
        }

        
    }

    private RoadObject createRoadObject(RoadObjectType type, int x, int y) {
        if (type == RoadObjectType.THORN) {
            return new Thorn(x, y);
        } else if (type == RoadObjectType.DRUNK_CAR) {
            return new MovingCar(x, y);
        } else if (type != RoadObjectType.DRUNK_CAR) {
            return new Car(type, x, y);
        }
        else
            return null;
    }

    public void draw(Game game) {
        for (RoadObject item : items) {
            item.draw(game);
        }
    }

    public void move(int boost) {
        for (RoadObject item : items) {
            item.move(boost + item.speed, items);
        }
        deletePassedItems();
    }

    private boolean isThornExists() {
        for (RoadObject item : items) {
            if (item.type == RoadObjectType.THORN){
                return true;
            }
        }
        return false;
    }

    private void generateThorn(Game game) {
        if (game.getRandomNumber(100) < 10 && !isThornExists()) {
            addRoadObject(RoadObjectType.THORN, game);
        }

    }
    public void generateNewRoadObjects(Game game) {
        generateThorn(game);
        generateRegularCar(game);
        generateMovingCar(game);
    }

    private void deletePassedItems() {
        Iterator<RoadObject> roadObjectIterator = items.iterator();
        while (roadObjectIterator.hasNext()) {
            RoadObject roadObject = roadObjectIterator.next();
            if (roadObject.y >= RacerGame.HEIGHT){
                roadObjectIterator.remove();
                if (roadObject.type != RoadObjectType.THORN)
                    passedCarsCount++;
            }
        }
    }

    public boolean checkCrush(PlayerCar car) {
        for (RoadObject item : items) {
            if (item.isCollision(car)){
                return true;
            }
        }
        return false;
    }
    private void generateRegularCar(Game game) {
        int carTypeNumber = game.getRandomNumber(4);

        if (game.getRandomNumber(100) < 30)
            addRoadObject(RoadObjectType.values()[carTypeNumber], game);
    }

    private boolean isRoadSpaceFree(RoadObject object) {
        for (RoadObject item : items) {
            if (item.isCollisionWithDistance(object, PLAYER_CAR_DISTANCE)){
                return false;
            }
        }
        return true;
    }
    private boolean isMovingCarExists() {
        for (RoadObject item : items) {
            if (item instanceof MovingCar){
                return true;
            }
        }
        return false;
    }
    private void generateMovingCar(Game game) {
        if (game.getRandomNumber(100) < 10 && !isMovingCarExists()) {
            addRoadObject(RoadObjectType.DRUNK_CAR, game);
        }
    }

    public int getPassedCarsCount() {
        return passedCarsCount;
    }
}
