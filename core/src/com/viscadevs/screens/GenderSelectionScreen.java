package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.viscadevs.hackbo.HackBoGame;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Button;
import com.viscadevs.util.Enums;

import static com.viscadevs.hackbo.HackBoGame.batch;


public class GenderSelectionScreen extends ScreenAdapter {
    private HackBoGame game;
    private Button maleButton, femaleButton;

    public GenderSelectionScreen(HackBoGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        maleButton = new Button(Assets.getInstance().buttonAssets.male,
                Gdx.graphics.getWidth() / 7, Gdx.graphics.getHeight() / 3,
                Gdx.graphics.getWidth() / 7, Gdx.graphics.getHeight() / 3, Color.WHITE) {
            @Override
            public void onTouch() {
                game.setScreen(new GameScreen(Enums.Gender.MALE));
            }
        };
        femaleButton = new Button(Assets.getInstance().buttonAssets.female,
                Gdx.graphics.getWidth() * 5/ 7, Gdx.graphics.getHeight() / 3,
                Gdx.graphics.getWidth()/ 7, Gdx.graphics.getHeight() / 3, Color.WHITE) {
            @Override
            public void onTouch() {
                game.setScreen(new GameScreen(Enums.Gender.FEMALE));
            }
        };
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Color.SKY.r, Color.SKY.g, Color.SKY.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        maleButton.render();
        femaleButton.render();

        batch.end();
    }

    @Override
    public void dispose() {
        maleButton.dispose();
        femaleButton.dispose();
    }
}
