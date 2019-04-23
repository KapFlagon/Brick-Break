package com.jpgd.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick extends Shape{

    /*
    Variables
     */
    private int value;

    /*
    Constructors
     */
    public Brick(ShapeRenderer shapeRenderer, Color color) {
        super(shapeRenderer, color, 0, 0, 0, 0);
        value = 0;
    }
    public Brick(ShapeRenderer shapeRenderer, Color color, int value) {
        super(shapeRenderer, color, 0, 0, 0, 0);
        this.value = value;
    }
    public Brick(ShapeRenderer shapeRenderer, Color color, int value, float posX, float posY, float width, float height) {
        super(shapeRenderer, color, posX, posY, width, height);
        this.value = value;
    }
    public Brick(ShapeRenderer shapeRenderer, Color color, int value, float posX, float posY, float width, float height, float padding) {
        super(shapeRenderer, color, posX, posY, width, height);
        this.value = value;
        this.padding = padding;
    }

    /*
    Getters
     */
    public int getValue() {
        return value;
    }

    /*
    Setters
     */
    public void setValue(int value) {
        this.value = value;
    }
    public void setDimensions(float[] dimensions) {
        this.padding = dimensions[2];
        this.height = dimensions[1];
        this.width = dimensions[0];
    }

    /*
    Other Methods
    */
    public int hit() {
        if(isVisible == true) {
            isVisible = false;
            return value;
        } else {
            // Do nothing
            return 0;
        }
    }

    public void draw() {
        if(isVisible == true) {
            shapeRenderer.setColor(color);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.rect(posX + padding, posY + padding, width - (padding * 2), height - (padding));
            shapeRenderer.end();
        } else {
            // Do not draw
        }
    }
}
