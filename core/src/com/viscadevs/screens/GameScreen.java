package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.viscadevs.hackbo.HackBoGame;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Constants;

public class GameScreen extends ScreenAdapter {

    private HackBoGame game;
    private Viewport viewport;

    public GameScreen(HackBoGame game){
        this.game = game;
    }

    @Override
    public void show() {
        AssetManager am = new AssetManager();
        Assets.getInstance().init(am);

        viewport = new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(viewport.getCamera().combined);
        viewport.apply();

        game.batch.begin();
        game.batch.end();

    }

    @Override
    public void dispose() {

    }
}
