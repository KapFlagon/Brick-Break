package com.jpgd.game.utilities;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jpgd.game.BrickBreak;
import com.jpgd.game.objects.Paddle;

public class InputHandler extends InputAdapter {

    private Paddle paddle;
    private Viewport viewport;
    private int maxBufferSize;

    public InputHandler(Paddle paddle, Viewport viewport) {
        this.paddle = paddle;
        this.viewport = viewport;
        maxBufferSize = 40;
    }

    public void processInput(int keycode) {
        if(keycode == Input.Keys.LEFT) {
            if((paddle.getPosX() + paddle.getWidth()) < BrickBreak.V_WIDTH) {
                // Too far right
            }
            if(paddle.getPosX() < 0) {
                // Too far left
            }
        }

        if(keycode == Input.Keys.RIGHT) {

        }
    }
}
