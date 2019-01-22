package com.jpgd.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.jpgd.game.utilities.AudioManager;
import com.jpgd.game.utilities.GameAssetManager;
import com.jpgd.game.utilities.ScoreManager;

public class BrickBreak extends Game {

    /*
    Final Static Variables
     */
	public final static String TITLE = "Brick Break";
	public final static float V_HEIGHT = 480;
	public final static float V_WIDTH = 800;
	public final static float V_TEXT_SCALE = 1.4f;

	/*
	Variables
	 */
	private SpriteBatch spriteBatch;
	private OrthographicCamera orthographicCamera;
	private ExtendViewport extendViewport;
	private GameAssetManager gameAssetManager;
	private AudioManager audioManager;
	private ScoreManager scoreManager;
	private Preferences preferences;

	/*
	Getters
	 */
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

	public ScoreManager getScoreManager() {
		return scoreManager;
	}

	public Preferences getPreferences() {
		return preferences;
	}

	@Override
	public void create () {
		spriteBatch = new SpriteBatch();

		gameAssetManager = new GameAssetManager();
		gameAssetManager.done();
		audioManager = new AudioManager(gameAssetManager);
		orthographicCamera = new OrthographicCamera();
		extendViewport = new ExtendViewport(V_WIDTH, V_HEIGHT, orthographicCamera);
		preferences = Gdx.app.getPreferences("BrickBreakPres");
		scoreManager = new ScoreManager(this);
		//scoreManager.loadScoreData();

        //readPrefs();
        //this.setScreen(new StartState(this));
	}

	@Override
	public void render () {
	    orthographicCamera.update();
	    spriteBatch.setProjectionMatrix(orthographicCamera.combined);
	    super.render();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();

        spriteBatch.end();
	}
	
	@Override
	public void dispose () {
        spriteBatch.dispose();
	}

	@Override
    public void pause() {
	    super.pause();
    }

    @Override
    public void resume() {
	    super.resume();
    }

    @Override
    public void resize(int width, int height) {
	    super.resize(width, height);
    }
}
