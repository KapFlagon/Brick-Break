package com.jpgd.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle extends Shape {

    /*
    Variables
     */
    private float speed, boundaryX, boundaryY;

    public Paddle(ShapeRenderer shapeRenderer, Color color, float posX, float posY, float width, float height) {
        super(shapeRenderer, color, posX, posY, width, height);
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
}
