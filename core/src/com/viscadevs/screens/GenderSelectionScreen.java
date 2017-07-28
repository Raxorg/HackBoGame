package com.viscadevs.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.viscadevs.hackbo.HackBoGame;
import com.viscadevs.util.Button;
import com.viscadevs.util.Enums;

/**
 * Created by Joaco99 on 28/07/2017.
 */

public class GenderSelectionScreen extends ScreenAdapter {
    private HackBoGame game;
    private Button maleButton, femaleButton;

    public GenderSelectionScreen(HackBoGame game){
        this.game = game;
    }

    @Override
    public void show() {

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
