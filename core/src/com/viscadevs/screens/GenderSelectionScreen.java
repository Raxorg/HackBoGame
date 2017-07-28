package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.viscadevs.hackbo.HackBoGame;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Button;
import com.viscadevs.util.ButtonListener;
import com.viscadevs.util.Constants;
import com.viscadevs.util.Enums;

import static com.viscadevs.hackbo.HackBoGame.batch;


public class GenderSelectionScreen extends ScreenAdapter {
    private HackBoGame game;
    private Button maleButton, femaleButton, exitButton;

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
        exitButton = new Button(
                Assets.getInstance().buttonAssets.exit_arrow,
                Constants.EXIT_ARROW_BUTTON_X,
                Constants.EXIT_ARROW_BUTTON_Y,
                Constants.BUTTON_HEIGHT,
                Constants.BUTTON_HEIGHT,
                Color.RED
        ) {
            @Override
            public void onTouch() {
                game.setScreen(new MenuScreen(game));
            }
        };

        Button[] buttons = new Button[3];
        buttons[0] = maleButton;
        buttons[1] = femaleButton;
        buttons[2] = exitButton;
        Gdx.input.setInputProcessor(new ButtonListener(buttons));
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Color.SKY.r, Color.SKY.g, Color.SKY.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        maleButton.render();
        femaleButton.render();
        exitButton.render();

        batch.end();
    }

    @Override
    public void dispose() {
        maleButton.dispose();
        femaleButton.dispose();
        exitButton.dispose();
    }
}
