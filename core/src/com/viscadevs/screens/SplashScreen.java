package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.viscadevs.hackbo.HackBoGame;
import com.viscadevs.util.Assets2;
import com.viscadevs.util.Constants;
import com.viscadevs.util.Enums;

import static com.viscadevs.hackbo.HackBoGame.batch;
import static com.viscadevs.hackbo.HackBoGame.manager;

public class SplashScreen extends ScreenAdapter {

    private HackBoGame game;

    private Texture black;
    private Enums.SplashState state;
    private float alpha = 0;

    public SplashScreen(HackBoGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        state = Enums.SplashState.FADING_IN;
        black = new Texture(Gdx.files.internal("other/pixel.png"));
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.setColor(1, 1, 1, 1);
        batch.draw(
                Assets2.splash,
                0,
                0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );
        batch.setColor(0, 0, 0, 1 - alpha);
        batch.draw(
                black,
                0,
                0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );
        batch.end();

        switch (state) {
            case FADING_IN:
                alpha += Constants.FADING_SPEED * delta;
                if (alpha > 1) {
                    alpha = 1;
                    state = Enums.SplashState.WAITING_ASSETS;
                    // AQUI QUE SE CARGUEN LOS ASSETS
                    Assets.getInstance().init(manager);
                    // TEMPORALMENTE VAMOS AL FADE OUT (POR AHORA)
                    state = Enums.SplashState.FADING_OUT;
                }
                break;
            case FADING_OUT:
                alpha -= Constants.FADING_SPEED * delta;
                if (alpha < 0) {
                    alpha = 0;
                    endOfSplash();
                }
                break;
            default:
                break;
        }
    }

    private void endOfSplash() {
        game.endOfSplash();
    }
}
