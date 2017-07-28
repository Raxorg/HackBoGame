package com.viscadevs.hackbo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.viscadevs.screens.GameScreen;
import com.viscadevs.screens.SplashScreen;

public class HackBoGame extends Game {
    public static SpriteBatch batch;
    public static BitmapFont font;
	public static AssetManager manager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
		manager = new AssetManager();
        setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
		manager.dispose();
    }

    public void endOfSplash() {
        setScreen(new GameScreen());
    }
}
