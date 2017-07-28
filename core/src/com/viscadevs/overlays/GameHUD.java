package com.viscadevs.overlays;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.viscadevs.util.Constants;

import static com.viscadevs.hackbo.HackBoGame.batch;
import static com.viscadevs.hackbo.HackBoGame.font;

public class GameHUD {

    private final Viewport viewport;
    // TODO MONEY
    // TODO STATS
    // TODO BUTTONS

    public GameHUD() {
        viewport = new ExtendViewport(Constants.HUD_VIEWPORT_SIZE, Constants.HUD_VIEWPORT_SIZE);
    }

    public void render(int money) {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        font.setColor(Color.WHITE);
        font.getData().setScale(1);
        font.draw(batch, money + "", Constants.HUD_MARGIN, viewport.getWorldHeight() - Constants.HUD_MARGIN);
    }

}