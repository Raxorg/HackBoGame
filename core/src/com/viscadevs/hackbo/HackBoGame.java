package com.viscadevs.hackbo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.viscadevs.screens.GameScreen;

public class HackBoGame extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        font = new BitmapFont();
		setScreen(new GameScreen(this));
	}
	
	@Override
	public void dispose () {
        batch.dispose();
        font.dispose();
	}
}
