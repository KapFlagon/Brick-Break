package com.jpgd.game.states;

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
        initializeBricks(30);
        resetBricks();
    }

    /*
    Other Methods
     */
    public void resetBall() {

    }

    public void initializeBricks(int size) {
        bricks = new ArrayList<Brick>();
        for(int brickIter = 0; brickIter < size; brickIter++) {
            //bricks.add(new Brick());
        }
    }
    public void resetBricks() {

    }

    public void resetLives(int noOfLives){
        this.lives = noOfLives;
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
