package com.viscadevs.hackbo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.viscadevs.screens.MenuScreen;
import com.viscadevs.screens.SplashScreen;
import com.viscadevs.util.Assets;

public class HackBoGame extends Game {
    public static SpriteBatch batch;
    public static BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();

        Assets.getInstance().init();

        setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        Assets.getInstance().dispose();
    }

    public void endOfSplash() {
        // DERP
        setScreen(new MenuScreen(this));
    }
}
