package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.viscadevs.hackbo.HackBoGame;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Constants;
import com.viscadevs.util.Enums;

import static com.viscadevs.hackbo.HackBoGame.batch;

/**
 * Created by Kevin Viscafe on 28/7/17.
 */

public class StartScreen extends ScreenAdapter {
    private HackBoGame game;

    private Texture black, splash;
    private Enums.SplashState state;
    private float alpha = 0;

    public StartScreen(HackBoGame game) {
        this.game = game;
    }

    @Override
    public void show() {

        Assets.getInstance().soundAssets.disaster.play();
        state = Enums.SplashState.FADING_IN;
        black = new Texture(Gdx.files.internal("other/pixel.png"));
        splash = new Texture(Gdx.files.internal("other/start_screen.jpg"));
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(Gdx.input.isTouched()){
            game.setScreen(new MenuScreen(game));
        }
        batch.begin();
        batch.setColor(1, 1, 1, 1);
        batch.draw(
                splash,
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
                alpha += (Constants.FADING_SPEED/4) * delta;
                if (alpha > 1) {
                    alpha = 1;
                    state = Enums.SplashState.WAITING_ASSETS;
                    // AQUI QUE SE CARGUEN LOS ASSETS
                    Assets.getInstance().init();
                    // TEMPORALMENTE VAMOS AL FADE OUT (POR AHORA)
                    state = Enums.SplashState.FADING_OUT;
                }
                break;
            case FADING_OUT:
                alpha -= Constants.FADING_SPEED * delta;
                if (alpha < 0) {
                    alpha = 0;
                    endOfStart();
                }
                break;
            default:
                break;
        }
    }

    private void endOfStart() {
        game.endOfStart();
    }

    @Override
    public void dispose() {
        black.dispose();
        splash.dispose();
    }
}
