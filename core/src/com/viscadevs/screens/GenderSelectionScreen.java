package com.viscadevs.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.viscadevs.hackbo.HackBoGame;
import com.viscadevs.util.Button;
import com.viscadevs.util.Enums;


public class GenderSelectionScreen extends ScreenAdapter {
    private HackBoGame game;
    private Button maleButton, femaleButton;

    public GenderSelectionScreen(HackBoGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        game.setScreen(new GameScreen(Enums.Gender.MALE));
    }


    @Override
    public void render(float delta) {
        maleButton.render();
        femaleButton.render();
    }

    @Override
    public void dispose() {
        maleButton.dispose();
        femaleButton.dispose();
    }
}
