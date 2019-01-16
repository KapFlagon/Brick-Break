package com.jpgd.game.utilities;

import com.badlogic.gdx.assets.AssetManager;

public class GameAssetManager {

    AssetManager assetManager;

    public void done() {
        assetManager.finishLoading();
    }
}
