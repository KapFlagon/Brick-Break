package com.jpgd.game.utilities;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jpgd.game.BrickBreak;
import com.jpgd.game.objects.Paddle;

public class InputHandler extends InputAdapter {

    private Paddle paddle;
    private Viewport viewport;
    private int maxBufferSize, mouseX;
    private boolean leftDown, rightDown;

    public InputHandler(Paddle paddle, Viewport viewport) {
        this.paddle = paddle;
        this.viewport = viewport;
        maxBufferSize = 40;
        leftDown = false;
        rightDown = false;
    }

    public void processInput(int keycode) {
        if(keycode == Input.Keys.LEFT) {
            paddle.moveLeft(true);
            leftDown = true;
        }

        if(keycode == Input.Keys.RIGHT) {
            paddle.moveRight(true);
            rightDown = true;
        }
    }

    /*
    Overridden methods
    */
    @Override
    public boolean keyDown (int keycode) {
        processInput(keycode);
        return true;
    }

    @Override
    public boolean keyUp (int keycode) {
        if (keycode == Input.Keys.LEFT) {
            if(rightDown == true) {
                paddle.moveRight(true);
            } else {
                paddle.moveLeft(false);
            }
            leftDown = false;
        }

        if (keycode == Input.Keys.RIGHT) {
            if(leftDown == true) {
                paddle.moveLeft(true);
            } else {
                paddle.moveLeft(false);
            }
            rightDown = false;
        }
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        Vector2 projectedCoordinates = viewport.unproject(new Vector2 (screenX, screenY));
        if(projectedCoordinates.x < 0) {
            paddle.setPosX(0);
        } else if((projectedCoordinates.x + paddle.getWidth()) >= BrickBreak.V_WIDTH) {
            paddle.setPosX(BrickBreak.V_WIDTH - paddle.getWidth());
        } else {
            paddle.setPosX(projectedCoordinates.x);
        }
        return true;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector2 projectedCoordinates = viewport.unproject(new Vector2 (screenX, screenY));
        if(projectedCoordinates.x < 0) {
            paddle.setPosX(0);
        } else if((projectedCoordinates.x + paddle.getWidth()) >= BrickBreak.V_WIDTH) {
            paddle.setPosX(BrickBreak.V_WIDTH - paddle.getWidth());
        } else {
            paddle.setPosX(projectedCoordinates.x);
        }
        return true;
    }
}
