package com.viscadevs.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.viscadevs.hud.Bar;
import com.viscadevs.hud.Upgrade;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Constants;

import static com.viscadevs.hackbo.HackBoGame.batch;
import static com.viscadevs.hackbo.HackBoGame.font;

public class GameHUD {

    private Bar[] bars;
    private Upgrade[] upgrades;

    public GameHUD() {
        bars = new Bar[2];
        bars[0] = new Bar(
                new Vector2(0, 0),
                Color.RED
        );
        bars[1] = new Bar(
                new Vector2(Constants.BAR_WIDTH + Constants.BAR_HEIGHT * 2, 0),
                Color.BLUE
        );

        upgrades = new Upgrade[1];

    }

    public void render(int money) {
        batch.draw(
                Assets.getInstance().hudAssets.moneyBar,
                0,
                Gdx.graphics.getHeight() - Constants.MONEY_BAR_HEIGHT,
                Constants.MONEY_BAR_WIDTH,
                Constants.MONEY_BAR_HEIGHT
        );
        font.setColor(Color.BLUE);
        font.getData().setScale(1);
        font.draw(batch, money + "", 0, 0);

        for (Bar bar : bars) {
            bar.render();
        }
    }

}