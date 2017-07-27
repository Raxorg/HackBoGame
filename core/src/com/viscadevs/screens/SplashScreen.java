package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.viscadevs.util.Enums;

public class SplashScreen extends ScreenAdapter {

    private long startTime;
    private Texture splashImage;
    private Enums.SplashState state;
    private float alpha = 0;
    private ShapeRenderer renderer;

    @Override
    public void show() {
        state = Enums.SplashState.FADING_IN;
        startTime = TimeUtils.nanoTime();
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(0, 0, 0, alpha);
        renderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        renderer.end();
        switch (state) {
            case FADING_IN:
                alpha = alpha + 0.05f > 1 ? 1 : alpha + 0.05f;
                System.out.println(alpha);
                break;
            case FADING_OUT:
                alpha = alpha - 0.05f < 0 ? 0 : alpha - 0.05f;
                System.out.println(alpha);
                break;
            default:
                break;
        }
    }
}
