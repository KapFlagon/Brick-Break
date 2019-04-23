package com.jpgd.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.jpgd.game.BrickBreak;
import com.jpgd.game.utilities.AudioManager;
import com.jpgd.game.utilities.GameAssetManager;

public abstract class State implements Screen{

    /*
    Variables
     */
    protected BrickBreak brickBreak;
    protected SpriteBatch spriteBatch;
    protected OrthographicCamera orthographicCamera;
    protected ExtendViewport extendViewport;
    protected GameAssetManager gameAssetManager;
    protected AudioManager audioManager;
    protected Stage stateStage;

    /*
    Constructors
     */
    public State(BrickBreak brickBreak) {
        this.brickBreak = brickBreak;
        this.spriteBatch = brickBreak.getSpriteBatch();
        this.orthographicCamera = brickBreak.getOrthographicCamera();
        this.extendViewport = brickBreak.getExtendViewport();
        this.gameAssetManager = brickBreak.getGameAssetManager();
        this.audioManager = brickBreak.getAudioManager();
        this.stateStage = new Stage(this.extendViewport);
    }

    /*
    Getters
     */

    public BrickBreak getBrickBreak() {
        return brickBreak;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public OrthographicCamera getOrthographicCamera() {
        return orthographicCamera;
    }

    public ExtendViewport getExtendViewport() {
        return extendViewport;
    }

    public GameAssetManager getGameAssetManager() {
        return gameAssetManager;
    }

    public AudioManager getAudioManager() {
        return audioManager;
    }

    public Stage getStateStage() {
        return stateStage;
    }

    /*
    Setters
     */

    public void setBrickBreak(BrickBreak brickBreak) {
        this.brickBreak = brickBreak;
    }

    public void setSpriteBatch(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void setOrthographicCamera(OrthographicCamera orthographicCamera) {
        this.orthographicCamera = orthographicCamera;
    }

    public void setExtendViewport(ExtendViewport extendViewport) {
        this.extendViewport = extendViewport;
    }

    public void setGameAssetManager(GameAssetManager gameAssetManager) {
        this.gameAssetManager = gameAssetManager;
    }

    public void setAudioManager(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    public void setStateStage(Stage stateStage) {
        this.stateStage = stateStage;
    }

    /*
    Overridden methods
     */
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stateStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateStage.act(delta);
        stateStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        this.stateStage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        stateStage.dispose();
    }
}
