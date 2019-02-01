package com.jpgd.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball extends Shape {

    /*
    Variables
     */
    private float radius, diameter;
    private boolean isLive;

    /*
    Constructors
     */
    public Ball(ShapeRenderer shapeRenderer, Color color) {
        super(shapeRenderer, color, 0, 0, 4, 4);
        radius = getWidth() / 2;
        diameter = getWidth();
        this.isLive = false;
    }

    public Ball(ShapeRenderer shapeRenderer, Color color, float posX, float posY, float radius) {
        super(shapeRenderer, color, posX, posY, (radius * 2), (radius * 2));
        this.radius = radius;
        this.diameter = radius * 2;
        this.isLive = true;
    }

    /*
    Getters
     */
    public float getRadius() {
        return radius;
    }
    public float getDiameter() {
        return diameter;
    }
    public boolean isLive() {
        return isLive;
    }

    /*
    Setters
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }
    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }
    public void setLive(boolean live) {
        isLive = live;
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
