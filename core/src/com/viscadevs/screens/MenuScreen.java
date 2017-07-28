package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.viscadevs.hackbo.HackBoGame;
import com.viscadevs.util.Constants;

import static com.viscadevs.hackbo.HackBoGame.batch;


public class MenuScreen extends ScreenAdapter {

    private HackBoGame game;
    private Viewport viewport;
    private Image play_btn;
    private Image instructions_btn;
    private Image credits_btn;
    private Image exit_btn;
    private Stage stage;

    public MenuScreen(HackBoGame game){
        this.game = game;

    }

    @Override
    public void show() {
        viewport = new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);

        Texture button = new Texture(Gdx.files.internal("other/pixel.png"));

        stage = new Stage(viewport,batch);
        play_btn = new Image(button);
        play_btn.setBounds(10, 100, 300, 75);
        play_btn.setPosition(Constants.WORLD_HEIGHT/6, Constants.WORLD_WIDTH/3);
        play_btn.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                game.setScreen(game.GAME);
                return true;
            }
        });

        instructions_btn = new Image(button);
        instructions_btn.setBounds(10, 100, 300, 75);
        instructions_btn.setPosition(Constants.WORLD_HEIGHT/6, play_btn.getY()-100);
        instructions_btn.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                game.setScreen(game.GAME);
                return true;
            }
        });

        credits_btn = new Image(button);
        credits_btn.setBounds(10, 100, 300, 75);
        credits_btn.setPosition(Constants.WORLD_HEIGHT/6, instructions_btn.getY()-100);
        credits_btn.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                game.setScreen(game.GAME);
                return true;
            }
        });

        exit_btn = new Image(button);
        exit_btn.setBounds(10, 100, 300, 75);
        exit_btn.setPosition(Constants.WORLD_HEIGHT/6, credits_btn.getY()-100);
        exit_btn.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                game.setScreen(game.GAME);
                return true;
            }
        });


        stage.addActor(play_btn);
        stage.addActor(instructions_btn);
        stage.addActor(credits_btn);
        stage.addActor(exit_btn);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(viewport.getCamera().combined);
        viewport.apply();
        stage.act();
        stage.draw();

    }
    @Override
    public void dispose() {
        super.dispose();
    }
}
