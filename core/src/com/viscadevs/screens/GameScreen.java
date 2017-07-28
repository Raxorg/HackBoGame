package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.viscadevs.entities.Player;
import com.viscadevs.overlays.GameHUD;
import com.viscadevs.util.Constants;
import com.viscadevs.util.Enums;

import static com.viscadevs.hackbo.HackBoGame.batch;

public class GameScreen extends ScreenAdapter {

    private Viewport viewport;
    private Player player;
    private DelayedRemovalArray people;
    private GameHUD gameHUD;

    @Override
    public void show() {
        viewport = new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        gameHUD = new GameHUD();
        // TODO GET THE NAME AND GENDER FROM MENU
        player = new Player("BOB", 50, Enums.Gender.MALE, 60, 0, 0, new Vector2(0, 0));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(viewport.getCamera().combined);
        viewport.apply();
        batch.begin();
        gameHUD.render(player.getMoney());
        // TODO RENDER THE BACKGROUND
        // TODO RENDER THE PLAYER
        // TODO RENDER THE HUD
        batch.end();
    }

    /**
     * This method spawns an NPC the player can interact with
     */
    private void spawnPerson() {
        // TODO stuff
    }

}