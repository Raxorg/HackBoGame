package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.viscadevs.hackbo.HackBoGame;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Button;
import com.viscadevs.util.ButtonListener;
import com.viscadevs.util.Constants;

import static com.viscadevs.hackbo.HackBoGame.batch;


public class MenuScreen extends ScreenAdapter {

    private HackBoGame game;
    private Button[] buttons;

    public MenuScreen(HackBoGame game) {
        this.game = game;
        buttons = new Button[3];
    }

    @Override
    public void show() {
        buttons[0] = new Button(
                Assets.getInstance().buttonAssets.start,
                Constants.START_BUTTON_X,
                Constants.START_BUTTON_Y,
                Constants.BUTTON_WIDTH,
                Constants.BUTTON_HEIGHT,
                Color.RED
        ) {
            @Override
            public void onTouch() {
                game.setScreen(new GameScreen());
            }
        };

        buttons[1] = new Button(
                Assets.getInstance().buttonAssets.instructions,
                Constants.INSTRUCTIONS_BUTTON_X,
                Constants.INSTRUCTIONS_BUTTON_Y,
                Constants.BUTTON_WIDTH,
                Constants.BUTTON_HEIGHT,
                Color.BLUE
        ) {
            @Override
            public void onTouch() {
                // TODO START
            }
        };

        buttons[2] = new Button(
                Assets.getInstance().buttonAssets.credits,
                Constants.CREDITS_BUTTON_X,
                Constants.CREDITS_BUTTON_Y,
                Constants.BUTTON_WIDTH,
                Constants.BUTTON_HEIGHT,
                Color.GREEN
        ) {
            @Override
            public void onTouch() {
                // TODO START
            }
        };

        Gdx.input.setInputProcessor(new ButtonListener(buttons));
    }

    @Override
    public void render(float delta) {
        batch.begin();
        for (Button b : buttons) {
            b.render();
        }
        batch.setColor(1, 1, 1, 1);
        batch.end();
    }

}
