package com.jpgd.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.jpgd.game.BrickBreak;

public class Paddle extends Shape {

    /*
    Variables
     */
    private float speed, boundaryX, boundaryY;
    private enum Movement {
        LEFT (-1),
        RIGHT (1),
        STATIONARY (0);

        private final int direction;
        Movement(int directionValue) {
            this.direction = directionValue;
        }
    }
    private Movement direction;

    public Paddle(ShapeRenderer shapeRenderer, Color color, float posX, float posY, float width, float height) {
        super(shapeRenderer, color, posX, posY, width, height);
        direction = Movement.STATIONARY;
    }

    /*
    Getters
     */
    public float getSpeed() {
        return speed;
    }

    public float getBoundaryX() {
        return boundaryX;
    }

    public float getBoundaryY() {
        return boundaryY;
    }

    /*
    Setters
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setBoundaryX(float boundaryX) {
        this.boundaryX = boundaryX;
    }

    public void setBoundaryY(float boundaryY) {
        this.boundaryY = boundaryY;
    }


    /*
    Other Methods
     */
    @Override
    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(posX, posY, width, height);
        shapeRenderer.end();
    }

    public void moveLeft(boolean moveLeft) {
        if(moveLeft == true) {
            direction = Movement.LEFT;

        } else {
            // Do not move left, switch to stationary
            direction = Movement.STATIONARY;
        }
    }

    public void moveRight(boolean moveRight) {
        if(moveRight == true) {
            direction = Movement.RIGHT;
        } else {
            // Do not move right, switch to stationary
            direction = Movement.STATIONARY;
        }
    }

    public void move(float delta) {
        if(direction == Movement.LEFT) {
            if (getPosX() <= 0) {
                // Too far left, stop moving
            } else {
                setPosX(getPosX() - (getSpeed() * delta));
            }
        } else if(direction == Movement.RIGHT) {
            if((getPosX() + getWidth()) >= BrickBreak.V_WIDTH) {
                // Too far right, stop moving
            } else {
                setPosX(getPosX() + (getSpeed() * delta));
            }
        } else {
            // Do nothing
        }
    }
}
