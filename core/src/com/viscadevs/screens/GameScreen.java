package com.viscadevs.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.viscadevs.util.Assets;

public class GameScreen extends ScreenAdapter {

    SpriteBatch batch;
    BitmapFont font;


    @Override
    public void show() {
        AssetManager am = new AssetManager();
        Assets.getInstance().init(am);

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void dispose() {

    }
}
