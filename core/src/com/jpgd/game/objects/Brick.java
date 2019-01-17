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
    public Brick(ShapeRenderer shapeRenderer, Color color, int value, float posX, float posY, float width, float height) {
        super(shapeRenderer, color, posX, posY, width, height);
        this.value = value;
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
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(color);
            shapeRenderer.rect(posX, posY, width, height);
            shapeRenderer.end();
        } else {
            // Do not draw
        }
    }
}
