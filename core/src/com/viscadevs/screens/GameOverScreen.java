package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.viscadevs.hackbo.HackBoGame;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Button;
import com.viscadevs.util.ButtonListener;
import com.viscadevs.util.Constants;

import static com.viscadevs.hackbo.HackBoGame.batch;

/**
 * Created by Kevin Viscafe on 28/7/17.
 */

public class GameOverScreen extends ScreenAdapter {

    HackBoGame game;

    public GameOverScreen(HackBoGame game){
        this.game = game;
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Color.SKY.r, Color.SKY.g, Color.SKY.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isTouched()){
            game.setScreen(new MenuScreen(game));
        }
        batch.begin();

        batch.draw(
                Assets.getInstance().landScapeAssets.gameover,
                0,
                0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );

        batch.setColor(1, 1, 1, 1);
        batch.end();
    }

}
