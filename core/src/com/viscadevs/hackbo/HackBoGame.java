package com.viscadevs.hackbo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.viscadevs.screens.SplashScreen;
import com.viscadevs.util.AssetManager;

public class HackBoGame extends Game {
    public static SpriteBatch batch;
    public static BitmapFont font;
    private AssetManager assetManager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();

        assetManager = new AssetManager();

        setScreen(new SplashScreen(this, assetManager));
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        assetManager.dispose();
    }

}
