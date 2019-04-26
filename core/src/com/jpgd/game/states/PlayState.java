package com.jpgd.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jpgd.game.BrickBreak;
import com.jpgd.game.objects.Ball;
import com.jpgd.game.objects.Brick;
import com.jpgd.game.objects.Paddle;
import com.jpgd.game.utilities.InputHandler;

import java.util.ArrayList;

public class PlayState extends State{

    /*
    Variables
     */
    private int lives;
    private Paddle paddle;
    private Ball ball;
    private ArrayList<Brick> bricks;
    private int speed;
    private float brickFieldHeight;
    protected ShapeRenderer shapeRenderer;
    private InputHandler inputHandler;

    /*
    Constructor
     */
    public PlayState(BrickBreak brickBreak) {
        super(brickBreak);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(orthographicCamera.combined);
        lives = 0;
        speed = 1;
        brickFieldHeight = (BrickBreak.V_HEIGHT / 5) * 3;

        resetLives(3);
        initializePaddle(500);
        resetPaddle();
        initializeBall(10);
        resetBall();
        initializeBricks();
        resetBricks();
        inputHandler = new InputHandler(paddle, extendViewport);
        //writeBricks();
    }

    /*
    Other Methods
     */
    public void initializeBall(float ballSpeed) {
        ball = new Ball(shapeRenderer, Color.WHITE);
        ball.setBallSpeed(ballSpeed);
        ball.setDiameter(25);
    }

    public void resetBall() {
        // TODO Set start position of ball, and reset state variables
        ball.makeBallLive();
        ball.setVisible(true);
        ball.setPosX((BrickBreak.V_WIDTH / 2));
        ball.setPosY(paddle.getPosY() + paddle.getHeight() + ball.getRadius() + 5);
    }

    public void initializePaddle(float paddleSpeed) {
        paddle = new Paddle(shapeRenderer, Color.WHITE, 0, 0, 100, 25);
        paddle.setSpeed(paddleSpeed);
    }

    public void resetPaddle() {
        paddle.setPosX((BrickBreak.V_WIDTH / 2) - (paddle.getWidth() / 2));
        paddle.setPosY(15);
    }

    public void initializeBricks() {
        float amountOfBricks = 48;

        float padding = 5;
        float blockWidth = (BrickBreak.V_WIDTH / 8);
        float blockHeight = (brickFieldHeight / 6);
        float brickFieldHeight_StartPoint = brickFieldHeight;

        bricks = new ArrayList<Brick>();

        for(int rows = 0; rows < 6; rows++) {
            for (int cols = 0; cols < 8; cols++) {
                if(rows == 0) {
                    //tempBrick.setColor(Color.RED);
                    bricks.add(new Brick(shapeRenderer, Color.RED, 10, (blockWidth * (cols)), brickFieldHeight_StartPoint + (blockHeight * rows), blockWidth, blockHeight, padding));
                } else if(rows == 1) {
                    //tempBrick.setColor(Color.ORANGE);
                    bricks.add(new Brick(shapeRenderer, Color.ORANGE, 10, (blockWidth * (cols)), brickFieldHeight_StartPoint + (blockHeight * rows), blockWidth, blockHeight, padding));
                } else if(rows == 2) {
                    //tempBrick.setColor(Color.BLUE);
                    bricks.add(new Brick(shapeRenderer, Color.BLUE, 10, (blockWidth * (cols)), brickFieldHeight_StartPoint + (blockHeight * rows), blockWidth, blockHeight, padding));
                } else if(rows == 3) {
                    //tempBrick.setColor(Color.YELLOW);
                    bricks.add(new Brick(shapeRenderer, Color.YELLOW, 10, (blockWidth * (cols)), brickFieldHeight_StartPoint + (blockHeight * rows), blockWidth, blockHeight, padding));
                } else if(rows == 4) {
                    //tempBrick.setColor(Color.GREEN);
                    bricks.add(new Brick(shapeRenderer, Color.GREEN, 10, (blockWidth * (cols)), brickFieldHeight_StartPoint + (blockHeight * rows), blockWidth, blockHeight, padding));
                } else if(rows == 5) {
                    //tempBrick.setColor(Color.PURPLE);
                    bricks.add(new Brick(shapeRenderer, Color.PURPLE, 10, (blockWidth * (cols)), brickFieldHeight_StartPoint + (blockHeight * rows), blockWidth, blockHeight, padding));
                }

                //tempBrick.setPosY(brickFieldHeight_StartPoint + (blockHeight * rows));
            }
        }
    }

    public void resetBricks() {

        for(int iterator = 0; iterator < bricks.size(); iterator++) {
            bricks.get(iterator).setVisible(true);
        }
    }

    public void resetLives(int noOfLives){
        this.lives = noOfLives;
    }

    public float[] brickDimensionCalculations(int rows, int columns) {
        float[] calculations = new float[3];
        // Element 0 is Width, element 2 is Height, element 3 is padding
        float brickFieldHeight = (BrickBreak.V_HEIGHT / 5) * 3;
        float padding = 1;
        calculations[0] = (BrickBreak.V_WIDTH / rows);
        calculations[1] = (brickFieldHeight / columns);
        calculations [2] = padding;
        return calculations;
    }

    public void calculateRowsAndCols() {
        // Find a way to determine best distribution of bricks over an even rows and columns grid
    }

    public void update(float delta) {
        paddle.move(delta);
        if(lives < 0 && ball.isLive()) {
            //TODO
            // ball.move();
        }
    }

    public void draw(float delta) {
        for(int i = 0; i < bricks.size(); i++) {
            bricks.get(i).draw();
        }
        ball.draw();
        paddle.draw();
    }

    public void writeBricks() {
        for (Brick brick : bricks) {
            System.out.println("\nraw X: " + brick.getPosX() + " raw Y: " + brick.getPosY() + " raw width: " + brick.getWidth() + " raw height: " + brick.getHeight() + " colour: " + brick.getColor() + " padding: " + brick.getPadding() + "\nfinal X: " + (brick.getPosX() + brick.getPadding()) + " final Y: " + (brick.getPosY() + brick.getPadding()) + " final Width: " + (brick.getWidth() - brick.getPadding()) + " final Height: " + (brick.getHeight() - brick.getPadding()));
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw(delta);
    }

    /*
    Implemented methods from Abstract Class
     */
    @Override
    public void show() {
        Gdx.input.setInputProcessor(inputHandler);
    }

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
