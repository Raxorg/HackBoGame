package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;
import com.viscadevs.util.Constants;
import com.viscadevs.util.Enums;

import static com.viscadevs.hackbo.HackBoGame.batch;

public class SplashScreen extends ScreenAdapter {

    private long startTime;
    private Texture black;
    private Enums.SplashState state;
    private float alpha = 0;

    @Override
    public void show() {
        state = Enums.SplashState.FADING_IN;
        startTime = TimeUtils.nanoTime();
        black = new Texture(Gdx.files.internal("pixel.png"));
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setColor(0, 0, 0, alpha);
        batch.begin();
        batch.draw(black, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        switch (state) {
            case FADING_IN:
                alpha = alpha + Constants.FADING_SPEED * delta > 1 ?
                        1 : alpha + Constants.FADING_SPEED * delta;
                System.out.println(alpha);
                break;
            case FADING_OUT:
                alpha = alpha - Constants.FADING_SPEED * delta < 0 ?
                        0 : alpha - Constants.FADING_SPEED * delta;
                System.out.println(alpha);
                break;
            default:
                break;
        }
    }
}
