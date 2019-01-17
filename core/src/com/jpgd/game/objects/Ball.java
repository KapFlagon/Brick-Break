package com.jpgd.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball extends Shape {

    /*
    Variables
     */
    private float radius, boundaryX, boundaryY;
    private boolean isLive;

    /*
    Constructors
     */
    public Ball(ShapeRenderer shapeRenderer, Color color, float posX, float posY, float radius) {
        super(shapeRenderer, color, posX, posY, (radius * 2), (radius * 2));
        this.radius = radius;
        this.isLive = true;
    }

    /*
    Getters
     */
    public float getRadius() {
        return radius;
    }
    public boolean isLive() {
        return isLive;
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
    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
    public void setBoundaryX(float boundaryX) {
        this.boundaryX = boundaryX;
    }
    public void setBoundaryY(float boundaryY) {
        this.boundaryY = boundaryY;
    }
    public void setBoundaries(float boundaryX, float boundaryY) {
        this.boundaryX = boundaryX;
        this.boundaryY = boundaryY;
    }

    /*
    Other methods
     */
    @Override
    public void draw() {
        if(isVisible && isLive) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(color);
            shapeRenderer.circle(posX, posY, radius);
            shapeRenderer.end();
        } else {
            // Do not draw
        }
    }
}
