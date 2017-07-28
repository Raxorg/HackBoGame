package com.viscadevs.hackbo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.viscadevs.screens.MenuScreen;
import com.viscadevs.screens.SplashScreen;

public class HackBoGame extends Game {
    public static SpriteBatch batch;
    public static BitmapFont font;
    public static com.badlogic.gdx.assets.AssetManager assetManager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();

        assetManager = new AssetManager();

        setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        assetManager.dispose();
    }

    public void endOfSplash() {
        // DERP
        setScreen(new MenuScreen(this));
    }
}
