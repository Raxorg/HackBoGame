package com.viscadevs.overlays;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.viscadevs.hud.Bar;

import static com.viscadevs.hackbo.HackBoGame.batch;
import static com.viscadevs.hackbo.HackBoGame.font;

public class GameHUD {

    private Bar[] bars;

    public GameHUD() {
        bars = new Bar[2];
        bars[0] = new Bar(new Vector2(0, 0), Color.RED);
        bars[1] = new Bar(new Vector2(200, 0), Color.BLUE);
    }

    // TODO MONEY
    // TODO STATS
    // TODO BUTTONS

    public void render(int money) {
        font.setColor(Color.WHITE);
        font.getData().setScale(1);
        font.draw(batch, money + "", 0, 0);

        for (Bar bar : bars) {
            bar.render();
        }
    }

}