package com.viscadevs.hackbo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.viscadevs.screens.GameScreen;

public class HackBoGame extends Game {
	public static SpriteBatch batch;
	public static BitmapFont font;
	
	@Override
	public void create () {
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose () {
	}
}
