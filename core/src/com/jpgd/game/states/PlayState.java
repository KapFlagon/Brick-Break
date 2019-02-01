package com.jpgd.game.states;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jpgd.game.BrickBreak;
import com.jpgd.game.objects.Ball;
import com.jpgd.game.objects.Brick;

import java.util.ArrayList;

public class PlayState extends State{

    /*
    Variables
     */
    private int lives;
    private int amountOfBricks;
    private Ball ball;
    private ArrayList<Brick> bricks;
    protected ShapeRenderer shapeRenderer;

    /*
    Constructor
     */
    public PlayState(BrickBreak brickBreak) {
        super(brickBreak);
        lives = 0;
        resetLives(3);
        resetBall();
        initializeBricks(40);
        resetBricks();
    }

    /*
    Other Methods
     */
    public void initializeBall() {
        ball = new Ball(shapeRenderer, Color.WHITE);
    }

    public void resetBall() {

    }

    public void initializeBricks() {
        bricks = new ArrayList<Brick>();
        // TODO Need a method to evenly distribute the blocks across rows and columns, and determine their color
        int rows;
        int columns;
        // TODO Need a method to calculate sizes and positions of blocks (brickDimensionCalculations)
        float[] dimensions = brickDimensionCalculations();
        for(int brickIter = 0; brickIter < amountOfBricks; brickIter++) {
            //bricks.add(new Brick());
        }
    }
    public void resetBricks() {

    }

    public void resetLives(int noOfLives){
        this.lives = noOfLives;
    }

    public float[] brickDimensionCalculations() {
        float[] calculations = new float[3];
        // Element 0 is Width, element13 is Height, element 3 is padding
        float brickFieldHeight = (BrickBreak.V_HEIGHT / 5) * 3;
        float padding = 1;
        calculations[0] = (BrickBreak.V_WIDTH / amountOfBricks) - (padding * 2);
        calculations[1] = (brickFieldHeight / amountOfBricks) - (padding * 2);
        calculations [2] = padding;
        return calculations;
    }

    public void calculateRowsAndCols() {
        // Find a way to determine best distribution of bricks over an even rows and columns grid
    }

    public void update(float delta) {

    }

    public void draw(float delta) {

    }

    /*
    Implemented methods from Abstract Class
     */
    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
