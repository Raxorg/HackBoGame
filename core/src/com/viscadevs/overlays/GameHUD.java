package com.viscadevs.overlays;

import com.badlogic.gdx.graphics.Color;
import com.viscadevs.hud.Bar;

import static com.viscadevs.hackbo.HackBoGame.batch;
import static com.viscadevs.hackbo.HackBoGame.font;

public class GameHUD {

    private Bar healthBar, energyBar;

    public GameHUD() {
        healthBar = new Bar();
    }

    // TODO MONEY
    // TODO STATS
    // TODO BUTTONS

    public void render(int money) {
        font.setColor(Color.WHITE);
        font.getData().setScale(1);
        font.draw(batch, money + "", 0, 0);
    }

}