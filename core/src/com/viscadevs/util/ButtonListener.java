package com.viscadevs.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class ButtonListener extends InputAdapter {

    private Button[] buttons;

    public ButtonListener(Button[] buttons) {
        this.buttons = buttons;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenY = Gdx.graphics.getHeight() - screenY;

        for(Button b : buttons) {
            if (b.isTouched(screenX,screenY)) {
                b.onTouch();
            }
        }

        return true;
    }
}
