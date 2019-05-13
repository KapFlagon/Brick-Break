package com.jpgd.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Ball extends Shape {

    /*
    Variables
     */
    private float radius, diameter, ballSpeed;
    private boolean isLive;
    private Vector2 position, direction;

    /*
    Constructors
     */
    public Ball(ShapeRenderer shapeRenderer, Color color) {
        super(shapeRenderer, color, 0, 0, 4, 4);
        position = new Vector2(0, 0);
        radius = getWidth() / 2;
        diameter = getWidth();
        this.isLive = false;
        direction = new Vector2(0, 0);
    }

    public Ball(ShapeRenderer shapeRenderer, Color color, float posX, float posY, float radius) {
        super(shapeRenderer, color, posX, posY, (radius * 2), (radius * 2));
        position = new Vector2(posX, posY);
        this.radius = radius;
        this.diameter = radius * 2;
        this.isLive = true;
        direction = new Vector2(0, 0);
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
    public float getBallSpeed() {
        return ballSpeed;
    }
    public boolean isLive() {
        return isLive;
    }
    public Vector2 getPosition() {
        return position;
    }
    public Vector2 getDirection() {
        return direction;
    }
    @Override
    public float getPosX() {
        return position.x;
    }
    @Override
    public float getPosY() {
        return position.y;
    }

    /*
    Setters
     */
    public void setRadius(float radius) {
        this.radius = radius;
        this.diameter = radius * 2;
    }
    public void setDiameter(float diameter) {
        this.diameter = diameter;
        this.radius = diameter / 2;
    }
    public void setBallSpeed(float ballSpeed) {
        this.ballSpeed = ballSpeed;
    }
    public void makeBallLive() {
        isLive = true;
    }
    public void makeBallDead() {
        isLive = false;
    }
    public void setPosition(Vector2 position) {
        this.position = position;
    }
    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }
    @Override
    public void setPosX(float newX) {
        position.set(newX, position.y);
    }
    @Override
    public void setPosY(float newY) {
        position.set(position.x, newY);
    }


    /*
    Other methods
     */
    @Override
    public void draw() {
        if(isVisible && isLive) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(color);
            shapeRenderer.circle(position.x, position.y, radius);
            shapeRenderer.end();
        } else {
            // Do not draw
        }
    }

    public void move() {
        if(isVisible && isLive) {

        } else {
            // Do not move
        }
    }
}
