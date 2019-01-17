package com.jpgd.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Shape {

    /*
    Variables
     */
    protected ShapeRenderer shapeRenderer;
    protected Color color;
    protected boolean isVisible;
    protected float posX, posY, width, height;

    /*
    Constructors
     */
    public Shape(ShapeRenderer shapeRenderer, Color color, float posX, float posY, float width, float height) {
        this.shapeRenderer = shapeRenderer;
        this.color = color;
        this.isVisible = true;
        this. posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    /*
    Getters
     */
    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }
    public Color getColor() {
        return color;
    }
    public boolean isVisible() {
        return isVisible;
    }
    public float getPosX() {
        return posX;
    }
    public float getPosY() {
        return posY;
    }
    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }

    /*
    Setters
     */
    public void setShapeRenderer(ShapeRenderer shapeRenderer) {
        this.shapeRenderer = shapeRenderer;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setVisible(boolean visible) {
        isVisible = visible;
    }
    public void setPosX(float posX) {
        this.posX = posX;
    }
    public void setPosY(float posY) {
        this.posY = posY;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public void setHeight(float height) {
        this.height = height;
    }

    /*
    Other methods for implementation
     */
    public abstract void draw();
}
