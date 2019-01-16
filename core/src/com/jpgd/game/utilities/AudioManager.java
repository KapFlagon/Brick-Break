package com.jpgd.game.utilities;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {

    /*
    Variables
     */

    private GameAssetManager gameAssetManager;
    private Music music;
    private Sound breakingSound, bounceSound, scoringSound, failSound, gameoverSound;
    private String musicPath;
    private String breakingSoundPath, bounceSoundPath, scoringSoundPath, failSoundPath, gameoverSoundPath;
    private boolean musicOn, sfxOn;
    private float musicVolume, sfxVolume;

    public AudioManager(GameAssetManager gameAssetManager) {

    }

    /*
    Getters
     */
    public Music getMusic() {
        return music;
    }
    public Sound getBreakingSound() {
        return breakingSound;
    }
    public Sound getBounceSound() {
        return bounceSound;
    }
    public Sound getScoringSound() {
        return scoringSound;
    }
    public Sound getFailSound() {
        return failSound;
    }
    public Sound getGameoverSound() {
        return gameoverSound;
    }
    public boolean isMusicOn() {
        return musicOn;
    }
    public boolean isSfxOn() {
        return sfxOn;
    }
    public float getMusicVolume() {
        return musicVolume;
    }
    public float getSfxVolume() {
        return sfxVolume;
    }

    /*
    Setters
     */
    public void setMusicOn(boolean musicOn) {
        this.musicOn = musicOn;
        if(musicOn == true) {
            music.setLooping(true);
            music.play();
        } else {
            music.stop();
        }
    }
    public void setSfxOn(boolean sfxOn) {
        this.sfxOn = sfxOn;
    }
    public void setMusicVoume(float musicVolume) {
        this.musicVolume = musicVolume;
        music.setVolume(musicVolume);
    }
    public void setSfxVolume(float sfxVolume) {
        this.sfxVolume = sfxVolume;
    }

    /*
    Other methods
     */
    public void assignSFX() {

    }

    public void assignMusic() {

    }

    public void playBreakingSound() {
        if(sfxOn) {
            breakingSound.play(sfxVolume);
        }
    }

    public void playBounceSound() {
        if(sfxOn) {
            bounceSound.play(sfxVolume);
        }
    }

    public void playScoringSound() {
        if(sfxOn) {
            scoringSound.play(sfxVolume);
        }
    }

    public void playFailSound() {
        if(sfxOn) {
            failSound.play(sfxVolume);
        }
    }

    public void playGameoverSound() {
        if (sfxOn) {
            gameoverSound.play(sfxVolume);
        }
    }

}
