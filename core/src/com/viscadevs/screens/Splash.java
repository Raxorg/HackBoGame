package com.viscadevs.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;
import com.viscadevs.util.Enums;

public class Splash extends ScreenAdapter {

    private long startTime;
    private Texture splashImage;
    private Enums.SplashState state;

    @Override
    public void show() {
        startTime = TimeUtils.nanoTime();
    }

    public void render(float delta) {

    }
}
