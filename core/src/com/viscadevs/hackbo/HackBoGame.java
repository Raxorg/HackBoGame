package com.viscadevs.hackbo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.viscadevs.screens.GameScreen;
import com.viscadevs.screens.MenuScreen;
import com.viscadevs.screens.SplashScreen;
import com.viscadevs.util.Assets2;

public class HackBoGame extends Game {
    public static SpriteBatch batch;
    public static BitmapFont font;
    public static AssetManager manager;

    public final ScreenAdapter SPLASH, MENU, GAME;

    public HackBoGame() {
        SPLASH = new SplashScreen(this);
        MENU = new MenuScreen(this);
        GAME = new GameScreen();
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        manager = new AssetManager();
        Assets2.load();
        setScreen(SPLASH);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        manager.dispose();
    }

    public void endOfSplash() {
        setScreen(MENU);
    }
}
