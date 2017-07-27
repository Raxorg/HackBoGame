package com.viscadevs.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {

    private Assets instance = new Assets();
    private AssetManager assetManager;

    public Assets getInstance(){
        return instance;
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.finishLoading();
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}
