package com.viscadevs.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;
import com.viscadevs.util.Enums;

public class Splash extends ScreenAdapter {

    private long startTime;
    private Texture splashImage;
    private Enums.SplashState state;
    private float alpha = 0;

    @Override
    public void show() {
        state = Enums.SplashState.FADING_IN;
        startTime = TimeUtils.nanoTime();
    }

    public void render(float delta) {

        switch (state) {
            case FADING_IN:
                alpha += 0.05f;
                break;
            case FADING_OUT:
                alpha -= 0.05f;
                break;
            default:
                break;
        }
    }
}
